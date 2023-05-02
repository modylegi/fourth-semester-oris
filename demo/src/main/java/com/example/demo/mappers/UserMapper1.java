package com.example.demo.mappers;


import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper1 {

    @Mapping(target = "UserDto.Id")
    List<UserDto> from(List<User> user);

}
