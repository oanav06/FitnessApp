package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.model.dto.RoomRequestDto;
import com.example.FitnessApp.model.entities.Room;
import com.example.FitnessApp.repository.RoomRepository;
import com.example.FitnessApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(RoomRequestDto dto) {
        Room room = new Room();
        room.setCapacity(dto.capacity());
        room.setName(dto.name());
        Room roomSaved = roomRepository.save(room);
        return roomSaved;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }
}
