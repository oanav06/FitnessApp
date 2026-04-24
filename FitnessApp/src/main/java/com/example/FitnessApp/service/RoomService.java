package com.example.FitnessApp.service;

import com.example.FitnessApp.model.dto.RoomRequestDto;
import com.example.FitnessApp.model.entities.Room;

import java.util.List;

public interface RoomService {
    public Room createRoom(RoomRequestDto dto);
    public List<Room> getAllRooms();
    public Room getRoomById(Long id);
}
