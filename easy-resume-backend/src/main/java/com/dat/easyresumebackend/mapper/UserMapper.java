package com.dat.easyresumebackend.mapper;

import com.dat.easyresumebackend.domain.User;
import com.dat.easyresumebackend.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
@Mapper
public interface UserMapper {

    public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDto toUserDto(User user);

}
