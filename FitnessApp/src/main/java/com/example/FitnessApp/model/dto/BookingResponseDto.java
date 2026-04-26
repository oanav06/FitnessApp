package com.example.FitnessApp.model.dto;

import com.example.FitnessApp.model.enums.BookingStatus;

import java.time.LocalDate;

public record BookingResponseDto(
        Long id,
        Long workoutClassId,
        String workoutClassName,
        String roomName,
        LocalDate createdAt,
        BookingStatus status
) {

}
