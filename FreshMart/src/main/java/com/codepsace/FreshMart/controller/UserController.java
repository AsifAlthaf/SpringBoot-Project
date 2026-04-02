package com.codepsace.FreshMart.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepsace.FreshMart.dtos.UserRequestDTO;
import com.codepsace.FreshMart.dtos.UserResponseDTO;
import com.codepsace.FreshMart.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    
    private UserService userService;
    
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto){
        return userService.create(dto);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
       return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "User deleted!";
    }
}
