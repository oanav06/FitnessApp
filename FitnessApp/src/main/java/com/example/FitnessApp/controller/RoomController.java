package com.example.FitnessApp.controller;

import com.example.FitnessApp.model.dto.RoomRequestDto;
import com.example.FitnessApp.model.entities.Room;
import com.example.FitnessApp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody RoomRequestDto dto){
        return roomService.createRoom(dto);
    }

    @GetMapping
    public List<Room> getAllRooms(){
    return roomService.getAllRooms();

    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }
}
