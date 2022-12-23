package com.beyond.library.ddd.adapter.config;

import com.beyond.config.aop.ElapsedAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author beyond
 * @since 2022/12/23
 */
@Configuration
public class AopConfig {

    @Bean
    @Order
    public ElapsedAop elapsedAop() {
        return new ElapsedAop();
    }

}
