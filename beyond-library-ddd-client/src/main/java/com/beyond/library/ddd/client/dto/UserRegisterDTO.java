package com.beyond.library.ddd.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author beyond
 * @since 2022/11/14
 */
@Data
public class UserRegisterDTO implements Serializable {

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
