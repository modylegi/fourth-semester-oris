package org.example.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDTO toUserDto(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }

    public List<UserDTO> toUserDtoList(List<User> list) {
        return list.stream().map(this::toUserDto)
                .collect(Collectors.toList());
    }
}
