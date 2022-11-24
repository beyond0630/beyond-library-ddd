package com.beyond.library.ddd.application.event.publisher;

/**
 * @author beyond
 * @since 2022/11/15
 */
public interface EventPublisher {

    void publish(Object event);

}
