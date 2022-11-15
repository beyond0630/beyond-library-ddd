package com.beyond.library.ddd.application;

import com.beyond.library.ddd.application.event.AddUserEvent;
import com.beyond.library.ddd.application.event.publisher.impl.SpringEventPublisher;
import com.beyond.library.ddd.application.exe.cmd.AddUserCommandExecutor;
import com.beyond.library.ddd.client.UserService;
import com.beyond.library.ddd.client.cmd.AddUserCommand;
import com.beyond.library.ddd.client.dto.UserDTO;
import com.beyond.library.ddd.domain.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Service
public class UserServiceImpl implements UserService {

    private final SpringEventPublisher eventPublisher;
    private final AddUserCommandExecutor addUserCommandExecutor;

    public UserServiceImpl(final SpringEventPublisher eventPublisher,
                           final AddUserCommandExecutor addUserCommandExecutor) {
        this.eventPublisher = eventPublisher;
        this.addUserCommandExecutor = addUserCommandExecutor;
    }

    @Override
    public void addUser(final UserDTO userDTO) {
        final AddUserCommand command = AddUserCommand.create(userDTO);
        final User user = addUserCommandExecutor.execute(command);

        final AddUserEvent event = new AddUserEvent(this, user);
        eventPublisher.publish(event);

    }
}
