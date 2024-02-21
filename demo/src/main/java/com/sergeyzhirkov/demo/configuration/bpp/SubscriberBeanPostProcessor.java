package com.sergeyzhirkov.demo.configuration.bpp;

import annotation.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

@Slf4j
public class SubscriberBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Method method : bean.getClass().getMethods()) {
            if (method.isAnnotationPresent(Subscriber.class)) {
                log.info("   ***   subscriber added successfully!");
            }
        }
        return bean;
    }

}
