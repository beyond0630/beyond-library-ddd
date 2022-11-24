package com.beyond.library.ddd.application.event.listener.guava;

import com.beyond.library.ddd.application.event.AddUserEvent;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author beyond
 * @since 2022/11/24
 */
@Slf4j
@Component
public class AddUserEventListener extends AbstractGuavaEventListener<AddUserEvent> {

    protected AddUserEventListener(final EventBus eventBus) {
        super(eventBus);
    }

    @Override
    public void handler(final AddUserEvent event) {
        log.debug("handler event [{}]", event);
    }

}
