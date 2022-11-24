package com.beyond.library.ddd.application.service;

import com.beyond.library.ddd.domain.entity.User;

/**
 * @author beyond
 * @since 2022/11/24
 */
public interface UserService {
    void saveUser(User user);
}
