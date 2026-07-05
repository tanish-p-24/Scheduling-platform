package com.tanish.scheduling_platform.controller;

import com.tanish.scheduling_platform.dto.RegisterRequest;
import com.tanish.scheduling_platform.dto.UserResponse;
import com.tanish.scheduling_platform.model.User;
import com.tanish.scheduling_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // NEW
    @GetMapping("/me")
    public UserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // this is the email we set in JwtAuthFilter
        return userService.getCurrentUserResponse(email);
    }
}