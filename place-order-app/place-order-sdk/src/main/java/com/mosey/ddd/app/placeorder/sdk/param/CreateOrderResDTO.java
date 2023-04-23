package com.mosey.ddd.app.placeorder.sdk.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TangJie
 * @since 2023/4/17
 */
@Data
public class CreateOrderResDTO implements Serializable {
    private static final long serialVersionUID = 8455112101400856194L;

    private Long orderId;

    public CreateOrderResDTO(Long orderId){
        this.orderId = orderId;
    }
}
