package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ServImpl;

@RestController
@RequestMapping("/console")
public class UserController {

    @Autowired
    private ServImpl userService;


    @GetMapping("/welcome")
    public String hello() {
        return "Welcome to the Spring Boot Application!";
    }
    

    @GetMapping("/user")
    public UserDetails getCurrentUser(Authentication authentication) {
        return userService.loadUserByUsername(authentication.getName());
    }
}

