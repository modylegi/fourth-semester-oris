package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.mapper.UserMapper;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean existsByEmailAndPaAndPassword(String email, String password){
        return userRepository.existsByEmailAndAndPassword(email, password);
    }


}