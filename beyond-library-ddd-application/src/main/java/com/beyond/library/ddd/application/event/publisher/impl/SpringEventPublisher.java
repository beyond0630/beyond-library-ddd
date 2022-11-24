package com.beyond.library.ddd.application.event.publisher.impl;

import com.beyond.library.ddd.application.event.publisher.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author beyond
 * @since 2022/11/15
 */
@Slf4j//@Component
public class SpringEventPublisher implements EventPublisher {

    private final ApplicationContext applicationContext;

    public SpringEventPublisher(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void publish(final Object event) {
        if (log.isDebugEnabled()) {
            log.debug("publish event[{}]: {}", event.getClass().getName(), event);
        }
        applicationContext.publishEvent(event);
    }
}
