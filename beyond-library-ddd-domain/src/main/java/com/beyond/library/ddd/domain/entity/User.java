package com.beyond.library.ddd.domain.entity;

import com.beyond.library.ddd.domain.ApplicationContextHelper;
import com.beyond.library.ddd.domain.annotation.EntityComponent;
import com.beyond.library.ddd.domain.gateway.UserGateway;
import com.beyond.library.exception.BizException;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author beyond
 * @since 2022/11/11
 */
@Data
@EntityComponent
public class User implements Entity {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{4,20}$";

    /**
     * id
     */
    private Long id;

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

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 是否禁用
     */
    private Boolean disabled;

    public void checkUsername() {
        if (!this.username.matches(USERNAME_PATTERN)) {
            throw new BizException("invalid username");
        }

        final UserGateway userGateway = ApplicationContextHelper.getBean(UserGateway.class);
        if (userGateway.getUserByUsername(username) != null) {
            throw new BizException("duplicate username");
        }
    }


}
