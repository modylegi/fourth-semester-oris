package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.services.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping()
    List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
