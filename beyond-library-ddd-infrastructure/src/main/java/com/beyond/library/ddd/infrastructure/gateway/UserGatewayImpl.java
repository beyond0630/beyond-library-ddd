package com.beyond.library.ddd.infrastructure.gateway;

import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.domain.gateway.UserGateway;
import com.beyond.library.ddd.infrastructure.common.IdFactory;
import com.beyond.library.ddd.infrastructure.converter.UserConverter;
import com.beyond.library.ddd.infrastructure.po.UserPO;
import com.beyond.library.ddd.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author beyond
 * @since 2022/11/11
 */
@Component
public class UserGatewayImpl implements UserGateway {

    private final IdFactory idFactory;
    private final UserRepository userRepository;

    public UserGatewayImpl(final IdFactory idFactory, final UserRepository userRepository) {
        this.idFactory = idFactory;
        this.userRepository = userRepository;
    }


    @Override
    public User getUserByUsername(final String username) {
        final UserPO userPO = userRepository.getUserPOByUsername(username);
        return UserConverter.INSTANCE.convert(userPO);
    }

    @Override
    public long saveUser(final User user) {
        final long id = idFactory.generate();
        final UserPO userPO = UserConverter.INSTANCE.convert(user);
        userPO.setId(id);
        userPO.setDeleted(Boolean.FALSE);
        userPO.setCreatedBy(id);
        userPO.setCreatedAt(LocalDateTime.now());
        userPO.setModifiedBy(id);
        userPO.setModifiedAt(LocalDateTime.now());

        userRepository.save(userPO);
        return id;
    }
}
