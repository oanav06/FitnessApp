package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.model.dto.WorkoutClassRequestDto;
import com.example.FitnessApp.model.dto.WorkoutClassResponseDto;
import com.example.FitnessApp.model.entities.Room;
import com.example.FitnessApp.model.entities.WorkoutClass;
import com.example.FitnessApp.repository.RoomRepository;
import com.example.FitnessApp.repository.WorkoutClassRepository;
import com.example.FitnessApp.service.WorkoutClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutClassServiceImpl implements WorkoutClassService {
private final RoomRepository roomRepository;
private final WorkoutClassRepository workoutClassRepository;

    @Override
    public WorkoutClassResponseDto createWorkoutClass(WorkoutClassRequestDto dto) {
       WorkoutClass workoutClass = new WorkoutClass();
       workoutClass.setName(dto.name());
       workoutClass.setPrice(dto.price());
       workoutClass.setDuration(dto.duration());
       workoutClass.setCapacity(dto.capacity());
       WorkoutClass savedWorkoutClass = workoutClassRepository.save(workoutClass);

       return toDto(savedWorkoutClass);
    }


    @Override
    public List<WorkoutClassResponseDto> getAllWorkoutClasses() {
        return workoutClassRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public WorkoutClassResponseDto getWorkoutCLassById(Long id) {
        return toDto(workoutClassRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Class not found with id: " + id)));
    }

    @Override
    public WorkoutClassResponseDto updateWorkoutClass(Long id, WorkoutClassRequestDto dto) {
        WorkoutClass workoutClassFound = workoutClassRepository.findById(id).orElseThrow(()-> new RuntimeException("Class not found: " + id));
        Room room = roomRepository.findById(dto.roomId()).orElseThrow(() -> new RuntimeException("Roo not found"));
        workoutClassFound.setName(dto.name());
        workoutClassFound.setPrice(dto.price());
        workoutClassFound.setDuration(dto.duration());
        workoutClassFound.setCapacity(dto.capacity());
        workoutClassFound.setRoom(room);
        return toDto(workoutClassRepository.save(workoutClassFound));
    }

    @Override
    public void deleteWorkoutClass(Long id) {
        workoutClassRepository.deleteById(id);
    }
}
