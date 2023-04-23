package com.mosey.ddd.app.placeorder.runtime.service.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author TangJie
 * @since 2023/4/18
 */
@Data
public class ShoppingRequest implements Serializable {
    private static final long serialVersionUID = 2523654595898083197L;

    private Long buyId;
}
