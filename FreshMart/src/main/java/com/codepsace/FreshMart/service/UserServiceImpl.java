package com.codepsace.FreshMart.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codepsace.FreshMart.dtos.UserRequestDTO;
import com.codepsace.FreshMart.dtos.UserResponseDTO;
import com.codepsace.FreshMart.model.User;
import com.codepsace.FreshMart.mapper.UserMapper;
import com.codepsace.FreshMart.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO create(UserRequestDTO dto){
        // Convert dto to entity
        User user = UserMapper.toEntity(dto);

        // create the User record
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        //convert entity to dto
        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id).
        orElseThrow(() -> new RuntimeException("User is not found!"));
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll()
        .stream()
        .map(UserMapper::toDto)
        .toList();
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
