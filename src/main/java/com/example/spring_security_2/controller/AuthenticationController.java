package com.example.spring_security_2.controller;

import com.example.spring_security_2.entities.ApplicationUser;
import com.example.spring_security_2.entities.LoginResponseDto;
import com.example.spring_security_2.entities.RegistrationDto;
import com.example.spring_security_2.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.registerUser(registrationDto.getUsername(), registrationDto.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody RegistrationDto registrationDto) {
        return authenticationService.login(registrationDto.getUsername(), registrationDto.getPassword());
    }
}
