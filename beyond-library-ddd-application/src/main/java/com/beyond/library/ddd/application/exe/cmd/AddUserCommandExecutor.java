package com.beyond.library.ddd.application.exe.cmd;

import com.beyond.library.ddd.client.cmd.AddUserCommand;
import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.domain.entity.factory.EntityFactory;
import com.beyond.library.ddd.domain.gateway.UserGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Slf4j
@Component
public class AddUserCommandExecutor implements CommandExecutor<AddUserCommand, User>, InitializingBean {


    private final UserGateway userGateway;

    public AddUserCommandExecutor(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(final AddUserCommand addUserCmd) {
        final User user = EntityFactory.getEntity(User.class);
        user.setUsername(addUserCmd.getUserDTO().getUsername());
        user.setPassword(addUserCmd.getUserDTO().getPassword());
        user.setEmail(addUserCmd.getUserDTO().getEmail());
        user.setRegisterTime(LocalDateTime.now());
        user.setDisabled(Boolean.FALSE);

        user.checkUsername();
        final long id = userGateway.saveUser(user);
        user.setId(id);
        return user;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("initialized CommandExecutor[{}]..", this.getName());
        }
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

}
