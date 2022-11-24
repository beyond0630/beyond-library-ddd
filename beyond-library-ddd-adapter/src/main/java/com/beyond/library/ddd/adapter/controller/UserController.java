package com.beyond.library.ddd.adapter.controller;

import com.beyond.library.ddd.application.exe.cmd.UserRegisterCommandExecutor;
import com.beyond.library.ddd.client.cmd.UserRegisterCommand;
import com.beyond.library.ddd.client.dto.UserRegisterDTO;
import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beyond
 * @since 2022/11/14
 */
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRegisterCommandExecutor userRegisterCommandExecutor;

    public UserController(final UserRegisterCommandExecutor userRegisterCommandExecutor) {
        this.userRegisterCommandExecutor = userRegisterCommandExecutor;
    }

    @PostMapping
    public Result<Long> register(@RequestBody UserRegisterDTO userDTO) {
        final User user = userRegisterCommandExecutor.execute(UserRegisterCommand.create(userDTO));
        return Result.ok(user.getId());
    }

}
