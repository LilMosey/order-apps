package com.mosey.ddd.app.placeorder.runtime.service.res;

import com.mosey.ddd.order.domain.sdk.entity.OrderEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author TangJie
 * @since 2023/4/18
 */
@Data
public class ShoppingResult implements Serializable {
    private static final long serialVersionUID = -3442473615197307184L;

    private OrderEntity order;
}
