package com.beyond.library.ddd.infrastructure.common;

import com.beyond.library.ddd.infrastructure.common.impl.SnowflakeIdFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author lucifer
 * @since 2022/11/11
 */
@Configuration
public class BeanConfig {

    @Bean
    @Lazy
    public IdFactory idFactory() {
        return new SnowflakeIdFactory(0, 0);
    }

}