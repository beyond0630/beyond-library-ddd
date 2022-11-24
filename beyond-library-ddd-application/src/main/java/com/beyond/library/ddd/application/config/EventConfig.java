package com.beyond.library.ddd.application.config;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author beyond
 * @since 2022/11/24
 */
@Configuration
public class EventConfig {

    @Bean
    public Executor eventExecutor() {
        ThreadPoolTaskExecutor eventExecutor = new ThreadPoolTaskExecutor();
        eventExecutor.setCorePoolSize(4);
        eventExecutor.setMaxPoolSize(8);
        eventExecutor.setKeepAliveSeconds(60);
        eventExecutor.setQueueCapacity(10000);
        eventExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        eventExecutor.setThreadNamePrefix("event-pool-");
        eventExecutor.initialize();
        return eventExecutor;
    }

    @Bean
    public EventBus eventBus(final Executor eventExecutor) {
        return new AsyncEventBus("guava", eventExecutor);
    }

}
