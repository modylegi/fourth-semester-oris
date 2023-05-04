package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;


import java.util.List;


public interface UserService  {
    List<UserDto> getUsers();
    UserDto createUser(User user);


    void deleteUser(Long userId);


    UserDto updateUser(Long userId, String firstName, String lastName, String email, Integer age, String password);
}
