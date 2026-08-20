package com.tanish.scheduling_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class AvailabilityResponse {
    private Long id;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}