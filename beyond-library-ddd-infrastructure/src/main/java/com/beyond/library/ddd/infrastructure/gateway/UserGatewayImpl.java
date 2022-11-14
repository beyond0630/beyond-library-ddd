package com.beyond.library.ddd.infrastructure.gateway;

import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.domain.entity.factory.EntityFactory;
import com.beyond.library.ddd.domain.gateway.UserGateway;
import com.beyond.library.ddd.infrastructure.common.IdFactory;
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

    private User poToEntity(final UserPO userPO) {
        if (userPO == null) {
            return null;
        }
        final User user = EntityFactory.getEntity(User.class);
        user.setId(userPO.getId());
        user.setUsername(userPO.getUsername());
        user.setPassword(userPO.getPassword());
        user.setEmail(userPO.getEmail());
        user.setRegisterTime(userPO.getRegisterTime());
        user.setDisabled(userPO.getDisabled());
        return user;
    }

    @Override
    public User getUserByUsername(final String username) {
        final UserPO userPO = userRepository.getUserPOByUsername(username);
        return poToEntity(userPO);
    }

    @Override
    public void saveUser(final User user) {
        final long id = idFactory.generate();
        final UserPO userPO = new UserPO();
        userPO.setId(id);
        userPO.setUsername(user.getUsername());
        userPO.setPassword(user.getPassword());
        userPO.setEmail(user.getEmail());
        userPO.setRegisterTime(LocalDateTime.now());
        userPO.setDisabled(false);
        userPO.setDeleted(false);
        userPO.setCreatedBy(id);
        userPO.setCreatedAt(LocalDateTime.now());
        userPO.setModifiedBy(id);
        userPO.setModifiedAt(LocalDateTime.now());

        userRepository.save(userPO);
    }
}
