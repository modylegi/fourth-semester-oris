package com.example.demo.entities.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String password;
}
