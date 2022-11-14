package com.beyond.library.ddd.client.dto;

import lombok.Data;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Data
public class UserDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

}
