package com.mosey.ddd.app.placeorder.runtime.service.processor.order;

import com.mosey.ddd.app.placeorder.runtime.service.req.ShoppingRequest;
import com.mosey.ddd.app.placeorder.runtime.service.res.ShoppingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author TangJie
 * @since 2023/4/18
 * @desc 扣减库存processor
 */

@Component
public class DecreasingInventoryProcessor extends BaseOrderProcessor {


    @Override
    public ShoppingResult process(ShoppingResult shoppingResult, ShoppingRequest shoppingRequest) {
        System.out.println("扣减库存成功");
        return shoppingResult;
    }
}
