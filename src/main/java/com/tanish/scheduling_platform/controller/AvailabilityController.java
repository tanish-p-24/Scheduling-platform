package com.tanish.scheduling_platform.controller;

import com.tanish.scheduling_platform.dto.AvailabilityRequest;
import com.tanish.scheduling_platform.dto.AvailabilityResponse;
import com.tanish.scheduling_platform.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    private String getCurrentUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @PostMapping
    public AvailabilityResponse setAvailability(@RequestBody AvailabilityRequest request) {
        return availabilityService.setAvailability(getCurrentUserEmail(), request);
    }

    @GetMapping("/me")
    public List<AvailabilityResponse> getMyAvailability() {
        return availabilityService.getMyAvailability(getCurrentUserEmail());
    }

    @GetMapping("/{userId}")
    public List<AvailabilityResponse> getUserAvailability(@PathVariable Long userId) {
        return availabilityService.getUserAvailability(userId);
    }
}