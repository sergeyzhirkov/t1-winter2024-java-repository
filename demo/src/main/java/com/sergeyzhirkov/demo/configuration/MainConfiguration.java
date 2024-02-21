package com.sergeyzhirkov.demo.configuration;

import broker.MessageQueue;
import broker.Publisher;
import broker.Subscriber;
import com.sergeyzhirkov.demo.configuration.bpp.SubscriberBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public MessageQueue messageQueue() {
        return new MessageQueue();
    }

    @Bean
    public Publisher publisher() {
        return new Publisher(messageQueue());
    }

    @Bean
    public Subscriber subscriber() {
        return new Subscriber(messageQueue());
    }

    @Bean
    public SubscriberBeanPostProcessor subscriberBeanPostProcessor() {
        return new SubscriberBeanPostProcessor();
    }
}
