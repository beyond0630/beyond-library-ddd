package com.beyond.library.ddd.domain.gateway;

import com.beyond.library.ddd.domain.entity.User;

/**
 * @author beyond
 * @since 2022/11/11
 */
public interface UserGateway {

    User getUserByUsername(String username);

    void saveUser(User user);
}
