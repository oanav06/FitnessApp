package com.example.FitnessApp.repository;

import com.example.FitnessApp.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
