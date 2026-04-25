package com.example.FitnessApp.controller;

import com.example.FitnessApp.model.dto.WorkoutClassRequestDto;
import com.example.FitnessApp.model.dto.WorkoutClassResponseDto;
import com.example.FitnessApp.service.WorkoutClassService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutclasses")
@RequiredArgsConstructor
public class WorkoutClassController {

    private final WorkoutClassService workoutClassService;

    @Operation(summary = "Save a workoutclass in DB")
    @PostMapping
    public WorkoutClassResponseDto createWorkoutClass(@RequestBody WorkoutClassRequestDto dto){
        return workoutClassService.createWorkoutClass(dto);
    }

    @Operation(summary = "Get all workoutclasses from DB")
    @GetMapping
    public List<WorkoutClassResponseDto> getAllWorkoutclasses(){
        return workoutClassService.getAllWorkoutClasses();
    }

    @Operation(summary = "Get a workoutclass by id")
    @GetMapping("/{id}")
    public WorkoutClassResponseDto getWorkoutClassById(@PathVariable Long id){
        return workoutClassService.getWorkoutCLassById(id);
    }

    @Operation(summary = "Update workoutclass")
     @PutMapping("/{id}")
    public WorkoutClassResponseDto updateWorkoutClass(@PathVariable Long id,@RequestBody WorkoutClassRequestDto workoutClass){
         return workoutClassService.updateWorkoutClass(id, workoutClass);
     }

     @Operation(summary = "Delete workoutclass")
     @DeleteMapping("/{id}")
    public void deleteWorkoutClass(@PathVariable Long id){
        workoutClassService.deleteWorkoutClass(id);
     }

}
