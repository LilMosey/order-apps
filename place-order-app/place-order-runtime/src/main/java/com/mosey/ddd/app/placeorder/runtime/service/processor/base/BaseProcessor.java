package com.mosey.ddd.app.placeorder.runtime.service.processor.base;

/**
 * @author Rocky Yu
 * @since 2022/11/4
 */
public abstract class BaseProcessor<R, T> {

    public abstract R process(R r, T t);

    public Boolean isEffect(R r, T t){
        return true;
    }
}
