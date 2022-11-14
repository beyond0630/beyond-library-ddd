package com.beyond.library.ddd.application;

import com.beyond.library.ddd.application.exe.cmd.AddUserCommandExecutor;
import com.beyond.library.ddd.client.UserService;
import com.beyond.library.ddd.client.cmd.AddUserCommand;
import com.beyond.library.ddd.client.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Service
public class UserServiceImpl implements UserService {
    private final AddUserCommandExecutor addUserCommandExecutor;

    public UserServiceImpl(final AddUserCommandExecutor addUserCommandExecutor) {
        this.addUserCommandExecutor = addUserCommandExecutor;
    }

    @Override
    public void addUser(final UserDTO userDTO) {
        final AddUserCommand command = AddUserCommand.create(userDTO);
        addUserCommandExecutor.execute(command);

        // TODO 发布事件
    }
}
