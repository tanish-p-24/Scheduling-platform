package com.tanish.scheduling_platform.service;

import com.tanish.scheduling_platform.dto.AvailabilityRequest;
import com.tanish.scheduling_platform.dto.AvailabilityResponse;
import com.tanish.scheduling_platform.model.Availability;
import com.tanish.scheduling_platform.model.User;
import com.tanish.scheduling_platform.repository.AvailabilityRepository;
import com.tanish.scheduling_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private UserRepository userRepository;

    public AvailabilityResponse setAvailability(String email, AvailabilityRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Availability availability = Availability.builder()
                .user(user)
                .dayOfWeek(request.getDayOfWeek())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();

        Availability saved = availabilityRepository.save(availability);

        return new AvailabilityResponse(
                saved.getId(),
                saved.getDayOfWeek(),
                saved.getStartTime(),
                saved.getEndTime()
        );
    }

    public List<AvailabilityResponse> getMyAvailability(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return availabilityRepository.findByUser(user)
                .stream()
                .map(a -> new AvailabilityResponse(
                        a.getId(),
                        a.getDayOfWeek(),
                        a.getStartTime(),
                        a.getEndTime()
                ))
                .collect(Collectors.toList());
    }

    public List<AvailabilityResponse> getUserAvailability(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return availabilityRepository.findByUser(user)
                .stream()
                .map(a -> new AvailabilityResponse(
                        a.getId(),
                        a.getDayOfWeek(),
                        a.getStartTime(),
                        a.getEndTime()
                ))
                .collect(Collectors.toList());
    }
}