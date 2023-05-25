package org.example.controllers;


import lombok.*;


import org.example.models.AuthorizationRequest;
import org.example.models.RegistrationRequest;
import org.example.models.User;
import org.example.services.UserServiceImpl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final UserServiceImpl userService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){
        if(userService.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("Email is already taken", HttpStatus.BAD_REQUEST);
        }
        User user =  User.builder()
                .firstName(registrationRequest.getFirstName())
                .lastName(registrationRequest.getLastName())
                .email(registrationRequest.getEmail())
                .age(registrationRequest.getAge())
                .password(registrationRequest.getPassword())
                .build();
        userService.save(user);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @PostMapping("/authorize")
    public ResponseEntity<?> authorize(@RequestBody AuthorizationRequest authorizationRequest){
        if(userService.existsByEmailAndPaAndPassword(authorizationRequest.getEmail(), authorizationRequest.getPassword())){
            return new ResponseEntity<>("User authorized successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Email or password is incorrect!", HttpStatus.BAD_REQUEST);

    }


}
