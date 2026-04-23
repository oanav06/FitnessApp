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
    private String name;
    private String trainer;
    private int capacity;
    private Double price;
    private int duration;

    //room
    //bookings
    //scheduleDateTime

}
