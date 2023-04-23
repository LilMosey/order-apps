package com.mosey.ddd.app.placeorder.runtime.service.processor.order;

import com.mosey.ddd.app.placeorder.runtime.service.req.ShoppingRequest;
import com.mosey.ddd.app.placeorder.runtime.service.processor.base.BaseProcessor;
import com.mosey.ddd.app.placeorder.runtime.service.res.ShoppingResult;

/**
 * @author TangJie
 * @since 2023/4/18
 */
public abstract class BaseOrderProcessor extends BaseProcessor<ShoppingResult, ShoppingRequest> {
}
