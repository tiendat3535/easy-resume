package com.dat.easyresumebackend.mapper;

import com.dat.easyresumebackend.domain.User;
import com.dat.easyresumebackend.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserDtoMapper {

    public UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    User toUser(UserDto userDto);

}
