package com.beyond.library.ddd.application.service.impl;

import com.beyond.library.ddd.application.event.AddUserEvent;
import com.beyond.library.ddd.application.event.publisher.EventPublisher;
import com.beyond.library.ddd.application.service.UserService;
import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.domain.gateway.UserGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Service
public class UserServiceImpl implements UserService {

    private final EventPublisher eventPublisher;

    private final UserGateway userGateway;

    public UserServiceImpl(final EventPublisher eventPublisher,
                           final UserGateway userGateway) {
        this.eventPublisher = eventPublisher;
        this.userGateway = userGateway;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(final User user) {
        final long id = userGateway.saveUser(user);
        user.setId(id);

        final AddUserEvent event = new AddUserEvent(this, user);
        eventPublisher.publish(event);

    }
}
