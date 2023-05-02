package com.example.demo.servicies.impl;

import com.example.demo.entities.auth.AuthResponse;
import com.example.demo.entities.auth.AuthenticateRequest;
import com.example.demo.entities.auth.RegisterRequest;
import com.example.demo.entities.user.User;
import com.example.demo.entities.user.UserRole;
import com.example.demo.repositories.UserRepository;

import com.example.demo.security.token.Token;
import com.example.demo.security.token.TokenRepository;
import com.example.demo.security.token.TokenType;
import com.example.demo.security.utils.JwtUtil;
import com.example.demo.servicies.AuthService;
import com.example.demo.validators.EmailValidator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        boolean isValidEmail = emailValidator.test(registerRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        Optional<User> userOptional = userRepository.findUserByEmail(registerRequest.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        User registeredUser = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getAge(),
                encodedPassword,
                UserRole.USER
        );
        User savedUser = userRepository.save(registeredUser);
        String jwtToken = jwtUtil.generateToken(registeredUser);
        saveToken(savedUser, jwtToken);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
    @Override
    public AuthResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(),
                        authenticateRequest.getPassword()
                )
        );
        User authenticatedUser = userRepository.findUserByEmail(authenticateRequest.getEmail())
                .orElseThrow();
        revokeAndExpireAllUserTokens(authenticatedUser);
        String jwtToken = jwtUtil.generateToken(authenticatedUser);
        saveToken(authenticatedUser,jwtToken);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void revokeAndExpireAllUserTokens(User user){
        List<Token> validTokens =  tokenRepository.findAllValidTokensByUser(user.getId());
        if(!validTokens.isEmpty()){
            validTokens.forEach(token -> {
                token.setExpired(true);
                token.setRevoked(true);
            });
            tokenRepository.saveAll(validTokens);
        } else {
            return;
        }
    }


    private void saveToken(User user, String jwtToken) {
        Token token = Token.builder()
                .type(TokenType.BEARER)
                .user(user)
                .token(jwtToken)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }
}
