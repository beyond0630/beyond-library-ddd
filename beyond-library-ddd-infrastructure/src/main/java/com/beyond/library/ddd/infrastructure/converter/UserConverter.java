package com.beyond.library.ddd.infrastructure.converter;

import com.beyond.library.ddd.domain.entity.User;
import com.beyond.library.ddd.infrastructure.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author beyond
 * @since 2022/11/15
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User poToEntity(UserPO userPO);

    UserPO entityToPo(User user);
}
