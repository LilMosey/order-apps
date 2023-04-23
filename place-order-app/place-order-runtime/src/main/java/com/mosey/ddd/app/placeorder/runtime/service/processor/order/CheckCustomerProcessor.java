package com.mosey.ddd.app.placeorder.runtime.service.processor.order;

import com.mosey.ddd.app.placeorder.runtime.service.req.ShoppingRequest;
import com.mosey.ddd.app.placeorder.runtime.service.res.ShoppingResult;
import com.mosey.ddd.customer.domain.sdk.service.CustomerDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author TangJie
 * @since 2023/4/18
 * @desc 校验用户
 */
@Component
public class CheckCustomerProcessor extends BaseOrderProcessor{

    @Autowired
    private CustomerDomainService customerDomainService;



    @Override
    public ShoppingResult process(ShoppingResult shoppingResult, ShoppingRequest shoppingRequest) {
        if(customerDomainService.checkBlackByCustomerId(shoppingRequest.getBuyId())){
            throw new RuntimeException("黑名单");
        }


        return shoppingResult;
    }
}
