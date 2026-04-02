package com.codepsace.FreshMart.mapper;

import com.codepsace.FreshMart.dtos.UserRequestDTO;
import com.codepsace.FreshMart.dtos.UserResponseDTO;
import com.codepsace.FreshMart.model.User;

public class UserMapper {
    
    public static User toEntity(UserRequestDTO dto){
        return User.builder()
        .email(dto.getEmail())
        .name(dto.getName())
        .password(dto.getPassword())
        .build();
    }

    public static UserResponseDTO toDto(User user){
        return UserResponseDTO.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .build();
    }
}
