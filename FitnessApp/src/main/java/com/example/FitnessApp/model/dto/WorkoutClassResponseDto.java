package com.example.FitnessApp.model.dto;

public record WorkoutClassResponseDto(
    Long id, String name, Double price, int duration, int capacity
    )
{
}
