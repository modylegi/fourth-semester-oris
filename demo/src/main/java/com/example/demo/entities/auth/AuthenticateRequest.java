package com.example.demo.entities.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticateRequest {
    private String email;
    private String password;
}
