package com.beyond.library.ddd.application.event.publisher.impl;

import com.beyond.library.ddd.application.event.publisher.EventPublisher;
import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Component;

/**
 * @author beyond
 * @since 2022/11/24
 */
@Component
public class GuavaEventPublisher implements EventPublisher {

    private final EventBus eventBus;

    public GuavaEventPublisher(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publish(final Object event) {
        eventBus.post(event);
    }
}
