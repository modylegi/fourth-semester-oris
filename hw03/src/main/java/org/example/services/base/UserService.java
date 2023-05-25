package org.example.services.base;

import org.example.dto.UserDTO;
import org.example.models.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    void save(User user);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPaAndPassword(String email, String password);
}
