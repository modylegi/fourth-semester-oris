package org.example.controllers;


import lombok.*;

import org.example.dto.UserDTO;


import org.example.models.User;
import org.example.services.UserService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @GetMapping(produces = "application/json")
    List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping(value = "/sign-up", consumes = "application/json")
    public ResponseEntity<?> signUp(@RequestBody User user){
        if(userService.existsByEmail(user.getEmail())){
            return new ResponseEntity<>("Email is already taken", HttpStatus.BAD_REQUEST);
        }
        userService.save(user);
        return new ResponseEntity<>("User signed up successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/sign-in", consumes = "application/json" )
    public ResponseEntity<?> signIn(@RequestBody User user){
        if(userService.existsByEmailAndPaAndPassword(user.getEmail(),user.getPassword())){
            return new ResponseEntity<>("User signed in successfully!.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Email or password is incorrect!", HttpStatus.BAD_REQUEST);

    }
}
