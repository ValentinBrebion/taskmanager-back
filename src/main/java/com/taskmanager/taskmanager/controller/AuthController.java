package com.taskmanager.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.validation.Valid;
import com.taskmanager.taskmanager.payload.request.SignupRequest;
import com.taskmanager.taskmanager.services.UserService;
import com.taskmanager.taskmanager.entity.User;
import com.taskmanager.taskmanager.payload.response.MessageResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        // Create new user's account
        User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

        userService.saveOrUpdate(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
