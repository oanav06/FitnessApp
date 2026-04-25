package com.example.FitnessApp.model.dto;

public record WorkoutClassRequestDto(
        String name, Double price, int duration, int capacity
) {
}
