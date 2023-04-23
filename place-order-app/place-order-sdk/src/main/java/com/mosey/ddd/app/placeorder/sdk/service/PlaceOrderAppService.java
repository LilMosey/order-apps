package com.mosey.ddd.app.placeorder.sdk.service;

import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderReqDTO;
import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderResDTO;

/**
 * @author TangJie
 * @since 2023/4/17
 */
public interface PlaceOrderAppService {

    CreateOrderResDTO createOrder(CreateOrderReqDTO reqDTO);
}
