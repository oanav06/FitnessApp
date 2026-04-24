package com.example.FitnessApp.service;


import com.example.FitnessApp.model.entities.WorkoutClass;

import java.util.List;
import java.util.Optional;

public interface WorkoutClassService {

    public WorkoutClass createWorkoutClass(WorkoutClass workoutClass);
    public List<WorkoutClass> getAllWorkoutClasses();
    public WorkoutClass getWorkoutCLassById(Long Id);
    public WorkoutClass updateWorkoutClass(Long Id, WorkoutClass workoutClass);
    public void deleteWorkoutClass(Long Id);



}
