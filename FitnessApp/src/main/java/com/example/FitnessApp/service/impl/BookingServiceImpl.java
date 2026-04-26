package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.model.dto.BookingRequestDto;
import com.example.FitnessApp.model.dto.BookingResponseDto;
import com.example.FitnessApp.model.entities.Booking;
import com.example.FitnessApp.model.entities.Room;
import com.example.FitnessApp.model.entities.WorkoutClass;
import com.example.FitnessApp.model.enums.BookingStatus;
import com.example.FitnessApp.repository.BookingRepository;
import com.example.FitnessApp.repository.RoomRepository;
import com.example.FitnessApp.repository.WorkoutClassRepository;
import com.example.FitnessApp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final WorkoutClassRepository workoutClassRepository;
    private final RoomRepository roomRepository;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto dto) {
        WorkoutClass workoutClass = workoutClassRepository.findById(dto.workoutClassId())
                .orElseThrow(() -> new RuntimeException("Workout class not found"));


        // Room room = roomRepository.findById(dto.roomId())
        //.orElseThrow(() -> new RuntimeException("Room not found"));

        Booking booking = new Booking();
        booking.setWorkoutClass(workoutClass);
        booking.setCreatedAt(LocalDate.now());
        booking.setStatus(BookingStatus.ONHOLD);
        //booking.setRoom(room);

        return toDto(bookingRepository.save(booking));
    }

    @Override
    public BookingResponseDto confirmBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.ONHOLD) {
            throw new RuntimeException("Booking status already changed or cannot be confirmed");
        }

        booking.setStatus(BookingStatus.CONFIRMED);
        return toDto(bookingRepository.save(booking));
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

    }

    @Override
    public BookingResponseDto getBookingById(Long id) {
        return toDto(bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found")));
    }
}
