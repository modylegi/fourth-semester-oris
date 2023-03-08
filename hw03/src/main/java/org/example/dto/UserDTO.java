package org.example.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}
