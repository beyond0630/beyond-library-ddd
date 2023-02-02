package com.beyond.library.ddd.infrastructure.common;

import com.beyond.id.IdFactory;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author beyond
 */
@Component
public class GenerateSnowflakeId implements IdentifierGenerator {

    private final IdFactory idFactory;

    public GenerateSnowflakeId(final IdFactory idFactory) {
        this.idFactory = idFactory;
    }


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return idFactory.generate();
    }
}