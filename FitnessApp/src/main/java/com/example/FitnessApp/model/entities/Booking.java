package com.example.FitnessApp.model.entities;

import com.example.FitnessApp.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workoutclass_id")
    private WorkoutClass workoutClass;

    private LocalDate createdAt;
    private BookingStatus status = BookingStatus.NONE;


}
