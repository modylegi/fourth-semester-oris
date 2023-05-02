package com.example.demo.servicies;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService  {
    List<UserDto> getUsers();
    void createUser(User user);


    void deleteUser(Long userId);


    void updateUser(Long userId, String firstName, String lastName, String email, Integer age, String password);
}
