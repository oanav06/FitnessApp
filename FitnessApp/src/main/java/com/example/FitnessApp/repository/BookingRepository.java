package com.example.FitnessApp.repository;

import com.example.FitnessApp.model.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
