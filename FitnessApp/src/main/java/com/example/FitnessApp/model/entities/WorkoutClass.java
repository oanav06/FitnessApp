package com.example.FitnessApp.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workout_classes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkoutClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private String name;
    private Double price;
    private int duration;
    private int capacity;
    //room
    //bookings
    //scheduleDateTime
    // private String trainer;
}
