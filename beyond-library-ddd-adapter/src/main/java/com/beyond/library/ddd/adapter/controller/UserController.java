package com.beyond.library.ddd.adapter.controller;

import com.beyond.library.ddd.client.UserService;
import com.beyond.library.ddd.client.dto.UserDTO;
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

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return Result.ok();
    }

}
