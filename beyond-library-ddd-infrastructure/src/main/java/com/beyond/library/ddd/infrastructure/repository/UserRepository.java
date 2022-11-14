package com.beyond.library.ddd.infrastructure.repository;

import com.beyond.library.ddd.infrastructure.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author beyond
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<UserPO, Long> {

    UserPO getUserPOByUsername(String username);
}
