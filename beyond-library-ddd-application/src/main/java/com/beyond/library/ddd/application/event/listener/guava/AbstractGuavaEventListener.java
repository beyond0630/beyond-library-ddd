package com.beyond.library.ddd.application.event.listener.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author beyond
 * @since 2022/11/24
 */
@Slf4j
public abstract class AbstractGuavaEventListener<Event> implements InitializingBean, DisposableBean {

    protected final EventBus eventBus;

    protected AbstractGuavaEventListener(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Subscribe
    public abstract void handler(Event event);

    @Override
    public void destroy() throws Exception {
        log.debug("unregister listener {}", this.getClass().getName());
        eventBus.unregister(this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("register listener {}", this.getClass().getName());
        eventBus.register(this);
    }
}
