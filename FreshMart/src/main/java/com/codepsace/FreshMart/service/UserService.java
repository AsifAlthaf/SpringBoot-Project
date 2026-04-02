package com.codepsace.FreshMart.service;

import java.util.List;

import com.codepsace.FreshMart.dtos.UserRequestDTO;
import com.codepsace.FreshMart.dtos.UserResponseDTO;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    void delete(Long id);
}
