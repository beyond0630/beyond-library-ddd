package com.beyond.library.ddd.application.event.listener.spring;

import com.beyond.library.ddd.application.event.AddUserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * @author beyond
 * @since 2022/11/15
 */
@Slf4j
//@Component
public class AddUserEventListener implements ApplicationListener<AddUserEvent> {

    @Override
    @EventListener
    public void onApplicationEvent(final AddUserEvent event) {
        log.debug("handle event[{}] {}", event.getClass().getName(), event);
    }
}
