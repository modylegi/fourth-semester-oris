package com.example.demo.mappers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {


    UserDto toDto(User user);

}
