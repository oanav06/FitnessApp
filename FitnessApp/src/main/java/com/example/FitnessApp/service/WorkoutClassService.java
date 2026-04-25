package com.example.FitnessApp.service;


import com.example.FitnessApp.model.dto.WorkoutClassRequestDto;
import com.example.FitnessApp.model.dto.WorkoutClassResponseDto;
import com.example.FitnessApp.model.entities.WorkoutClass;

import java.util.List;
import java.util.Optional;

public interface WorkoutClassService {

    public WorkoutClassResponseDto createWorkoutClass(WorkoutClassRequestDto dto);
    public List<WorkoutClassResponseDto> getAllWorkoutClasses();
    public WorkoutClassResponseDto getWorkoutCLassById(Long Id);
    public WorkoutClassResponseDto updateWorkoutClass(Long Id, WorkoutClassRequestDto workoutClass);
    public void deleteWorkoutClass(Long Id);

    public default WorkoutClassResponseDto toDto(WorkoutClass workoutClass){
        WorkoutClassResponseDto dto = new WorkoutClassResponseDto(
                workoutClass.getId(),
                workoutClass.getName(),
                workoutClass.getPrice(),
                workoutClass.getDuration(),
                workoutClass.getCapacity()
        );
        return dto;
    }
}
