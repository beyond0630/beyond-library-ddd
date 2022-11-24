package com.beyond.library.ddd.client.cmd;

import com.beyond.library.ddd.client.dto.UserRegisterDTO;
import lombok.Data;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Data
public class UserRegisterCommand implements Command {

    private UserRegisterDTO userRegisterDTO;

    public static UserRegisterCommand create(UserRegisterDTO userRegisterDTO) {
        final UserRegisterCommand command = new UserRegisterCommand();
        command.setUserRegisterDTO(userRegisterDTO);
        return command;
    }
}
