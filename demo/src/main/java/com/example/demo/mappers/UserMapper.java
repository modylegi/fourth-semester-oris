package com.example.demo.mappers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
}
