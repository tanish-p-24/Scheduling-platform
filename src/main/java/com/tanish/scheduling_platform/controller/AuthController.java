package com.tanish.scheduling_platform.controller;

import com.tanish.scheduling_platform.dto.LoginRequest;
import com.tanish.scheduling_platform.dto.LoginResponse;
import com.tanish.scheduling_platform.dto.RegisterRequest;
import com.tanish.scheduling_platform.dto.UserResponse;
import com.tanish.scheduling_platform.service.AuthService;
import com.tanish.scheduling_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "Server is reachable";
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}