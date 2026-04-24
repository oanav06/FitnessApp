package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.model.entities.WorkoutClass;
import com.example.FitnessApp.repository.WorkoutClassRepository;
import com.example.FitnessApp.service.WorkoutClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutClassServiceImpl implements WorkoutClassService {

private final WorkoutClassRepository workoutClassRepository;

    @Override
    public WorkoutClass createWorkoutClass(WorkoutClass workoutClass) {
        return workoutClassRepository.save(workoutClass);
    }

    @Override
    public List<WorkoutClass> getAllWorkoutClasses() {
        return workoutClassRepository.findAll();
    }

    @Override
    public WorkoutClass getWorkoutCLassById(Long id) {
        return workoutClassRepository.findById(id).orElseThrow(()-> new RuntimeException("Class not found with id: " + id));
    }

    @Override
    public WorkoutClass updateWorkoutClass(Long id, WorkoutClass workoutClass) {
        WorkoutClass workoutClassFound = workoutClassRepository.findById(id).orElseThrow(()-> new RuntimeException("Class not found: " + id));
        workoutClassFound.setPrice(workoutClass.getPrice());
        workoutClassFound.setName(workoutClass.getName());
        workoutClassFound.setDuration(workoutClass.getDuration());
        workoutClassFound.setCapacity(workoutClass.getCapacity());
        return workoutClassRepository.save(workoutClassFound);
    }

    @Override
    public void deleteWorkoutClass(Long id) {
        workoutClassRepository.deleteById(id);
    }
}
