package com.example.FitnessApp.service;

import com.example.FitnessApp.model.dto.RoomRequestDto;
import com.example.FitnessApp.model.dto.RoomResponseDto;
import com.example.FitnessApp.model.entities.Room;

import java.util.List;

public interface RoomService {
    public RoomResponseDto createRoom(RoomRequestDto dto);
    public List<RoomResponseDto> getAllRooms();
    public RoomResponseDto getRoomById(Long id);

    public default RoomResponseDto toDto(Room room){
        return new RoomResponseDto(
                room.getId(),
                room.getCapacity(),
                room.getName()
        );
    }
}
