package com.mosey.ddd.app.placeorder.runtime.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author TangJie
 * @since 2023/4/18
 */
@Component
public class SpringApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringApplicationContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
    /**
     * 从spring 上下文中获取bean
     * @param name
     * @param requiredClass
     * @return
     */
    public static <T> T getBean(String name, Class<T>  requiredClass){
        return applicationContext.getBean(name, requiredClass);
    }
    public  static <T> T getBean(Class<T> requiredType){
        return applicationContext.getBean(requiredType);
    }

}
