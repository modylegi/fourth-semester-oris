package com.example.demo.servicies.impl;

import com.example.demo.entities.user.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.dto.UserDto;

import com.example.demo.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.example.demo.dto.UserDto.from;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return from(userRepository.findAll());
    }

    @Override
    public void createUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");

        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        ;


    }

    @Override
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException("user with id " + userId + " not exists");
        }
        userRepository.deleteById(userId);


    }


    @Override
    public void updateUser(Long userId, String firstName, String lastName, String email, Integer age, String password) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + " does not exist"
        ));
        if(firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }
        if(lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)){
            user.setFirstName(lastName);
        }
        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()){
                throw new IllegalStateException("email already taken");
            }
            user.setEmail(email);
        }
        if(age != null  && !Objects.equals(user.getAge(), age)){
            user.setAge(age);
        }
        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }
    }



}
