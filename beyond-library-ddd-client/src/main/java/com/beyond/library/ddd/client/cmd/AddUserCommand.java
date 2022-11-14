package com.beyond.library.ddd.client.cmd;

import com.beyond.library.ddd.client.dto.UserDTO;
import lombok.Data;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Data
public class AddUserCommand implements Command {

    private UserDTO userDTO;

    public static AddUserCommand create(UserDTO userDTO) {
        final AddUserCommand command = new AddUserCommand();
        command.setUserDTO(userDTO);
        return command;
    }
}
