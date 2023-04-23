package com.mosey.ddd.app.placeorder.runtime.service.impl;

import com.google.common.collect.Lists;
import com.mosey.ddd.app.placeorder.runtime.config.SpringApplicationContextHolder;
import com.mosey.ddd.app.placeorder.runtime.service.processor.order.BaseOrderProcessor;
import com.mosey.ddd.app.placeorder.runtime.service.processor.order.CheckCustomerProcessor;
import com.mosey.ddd.app.placeorder.runtime.service.processor.order.GenerateOrderProcessor;
import com.mosey.ddd.app.placeorder.runtime.service.req.ShoppingRequest;
import com.mosey.ddd.app.placeorder.runtime.service.res.ShoppingResult;
import com.mosey.ddd.app.placeorder.runtime.service.processor.order.DecreasingInventoryProcessor;
import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderReqDTO;
import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderResDTO;
import com.mosey.ddd.app.placeorder.sdk.service.PlaceOrderAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TangJie
 * @since 2023/4/17
 */
@Service
public class PlaceOrderAppServiceImpl implements PlaceOrderAppService {

    /**
     * step1:校验用户
     * step2:扣减库存
     * step3:生成订单
     */
    private final static List<BaseOrderProcessor> createOrderUserCase = Lists.newArrayList(
            SpringApplicationContextHolder.getBean(CheckCustomerProcessor.class),
            SpringApplicationContextHolder.getBean(DecreasingInventoryProcessor.class),
            SpringApplicationContextHolder.getBean(GenerateOrderProcessor.class));

    @Override
    public CreateOrderResDTO createOrder(CreateOrderReqDTO reqDTO) {
        ShoppingResult shoppingResult = new ShoppingResult();
        ShoppingRequest shoppingRequest = buildShopRequest();

        //责任链 简易的流程编排。
        createOrderUserCase.forEach(processor -> {
                    if (processor.isEffect(shoppingResult, shoppingRequest))
                        processor.process(shoppingResult, buildShopRequest());
                }
        );


        return new CreateOrderResDTO(shoppingResult.getOrder().getId());
    }

    private ShoppingRequest buildShopRequest() {
        return new ShoppingRequest();
    }
}
