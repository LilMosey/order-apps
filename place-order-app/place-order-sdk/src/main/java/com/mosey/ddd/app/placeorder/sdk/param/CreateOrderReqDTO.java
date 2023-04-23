package com.mosey.ddd.app.placeorder.sdk.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TangJie
 * @since 2023/4/17
 */
@Data
public class CreateOrderReqDTO implements Serializable {
    private static final long serialVersionUID = 1363304173030492362L;

    private Long buyId;

    private Long itemId;

    private Integer quantity;

}
