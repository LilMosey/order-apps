package com.mosey.ddd.app.placeorder.runtime.service.processor.order;

import com.mosey.ddd.app.placeorder.runtime.service.req.ShoppingRequest;
import com.mosey.ddd.app.placeorder.runtime.service.res.ShoppingResult;
import com.mosey.ddd.order.domain.sdk.entity.OrderEntity;
import com.mosey.ddd.order.domain.sdk.service.OrderDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author TangJie
 * @since 2023/4/19
 */
@Component
public class GenerateOrderProcessor extends BaseOrderProcessor{

    @Autowired
    private OrderDomainService orderDomainService;
    @Override
    public ShoppingResult process(ShoppingResult shoppingResult, ShoppingRequest shoppingRequest) {
        OrderEntity order = new OrderEntity();

        OrderEntity res = orderDomainService.createOrder(order);

        shoppingResult.setOrder(res);
        return shoppingResult;
    }
}
