package com.example.demo.servicies;

import com.example.demo.entities.auth.AuthResponse;
import com.example.demo.entities.auth.AuthenticateRequest;
import com.example.demo.entities.auth.RegisterRequest;


public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse authenticate(AuthenticateRequest authenticateRequest);
}
