package com.example.demo.repositories;

import com.example.demo.entities.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional()
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

}
