package com.example.demo.dto;

import com.example.demo.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Mapper(componentModel = "spring")
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

    public static List<UserDto> from(List<User> users){
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }

}
