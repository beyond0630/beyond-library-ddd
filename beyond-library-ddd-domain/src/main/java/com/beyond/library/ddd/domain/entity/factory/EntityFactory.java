package com.beyond.library.ddd.domain.entity.factory;

import com.beyond.library.ddd.domain.ApplicationContextHelper;

/**
 * @author beyond
 * @since 2022/11/11
 */
public final class EntityFactory {

    public static <T> T getEntity(Class<T> clz) {
        return ApplicationContextHelper.getBean(clz);
    }
}
