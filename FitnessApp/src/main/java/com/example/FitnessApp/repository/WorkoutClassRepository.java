package com.example.FitnessApp.repository;

import com.example.FitnessApp.model.entities.WorkoutClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutClassRepository extends JpaRepository<WorkoutClass, Long> {
}
