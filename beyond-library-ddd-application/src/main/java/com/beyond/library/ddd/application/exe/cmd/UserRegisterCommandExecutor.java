package com.beyond.library.ddd.application.exe.cmd;

import com.beyond.library.ddd.application.service.UserService;
import com.beyond.library.ddd.client.cmd.UserRegisterCommand;
import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.domain.entity.factory.EntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Slf4j
@Component
public class UserRegisterCommandExecutor extends CommandExecutor<UserRegisterCommand, User> {


    private final UserService userService;

    public UserRegisterCommandExecutor(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public User execute(final UserRegisterCommand command) {
        final User user = EntityFactory.getEntity(User.class);
        user.setUsername(command.getUserRegisterDTO().getUsername());
        user.setPassword(command.getUserRegisterDTO().getPassword());
        user.setEmail(command.getUserRegisterDTO().getEmail());
        user.setRegisterTime(LocalDateTime.now());
        user.setDisabled(Boolean.FALSE);

        user.checkUsername();
        userService.saveUser(user);
        return user;
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

}
