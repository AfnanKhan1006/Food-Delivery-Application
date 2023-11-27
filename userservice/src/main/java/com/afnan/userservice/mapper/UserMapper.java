package com.afnan.userservice.mapper;

import com.afnan.userservice.dto.UserRequestDto;
import com.afnan.userservice.dto.UserResponseDto;
import com.afnan.userservice.entity.User;
import jakarta.persistence.ManyToMany;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userResponseDtoToUser(UserResponseDto userResponseDto);
    User userRequestDtoToUser(UserRequestDto userRequestDto);

    UserRequestDto userToUserRequestDto(User user);
    UserResponseDto userToUserResponseDto(User user);

}
