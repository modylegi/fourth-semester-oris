package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.user.User;
import com.example.demo.servicies.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @Transactional
    @PutMapping(path ="{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String password) {
        userService.updateUser(userId,firstName,lastName,email,age,password);
    }



}
