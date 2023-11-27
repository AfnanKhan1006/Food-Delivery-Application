package com.afnan.userservice.service;

import com.afnan.userservice.dto.UserRequestDto;
import com.afnan.userservice.dto.UserResponseDto;
import com.afnan.userservice.entity.User;
import com.afnan.userservice.mapper.UserMapper;
import com.afnan.userservice.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRespository userRespository;
    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userRespository.save(UserMapper.INSTANCE.userRequestDtoToUser(userRequestDto));
        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRespository.findAll();
        return userList.stream().map(UserMapper.INSTANCE::userToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UserResponseDto> findUserById(Integer id) {
        Optional<User> user = userRespository.findById(id);
        return user.map(value -> new ResponseEntity<>(UserMapper.INSTANCE.userToUserResponseDto(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }
}
