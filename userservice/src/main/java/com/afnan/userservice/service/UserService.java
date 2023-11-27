package com.afnan.userservice.service;

import com.afnan.userservice.dto.UserRequestDto;
import com.afnan.userservice.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUser();

    ResponseEntity<UserResponseDto> findUserById(Integer id);
}
