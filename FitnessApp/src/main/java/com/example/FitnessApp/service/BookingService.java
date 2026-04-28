package com.example.FitnessApp.service;

import com.example.FitnessApp.model.dto.BookingRequestDto;
import com.example.FitnessApp.model.dto.BookingResponseDto;
import com.example.FitnessApp.model.entities.Booking;

public interface BookingService {
    public BookingResponseDto createBooking(BookingRequestDto dto);
    public BookingResponseDto confirmBooking(Long id);
    public void cancelBooking(Long id);
    public BookingResponseDto getBookingById(Long id);

    public default BookingResponseDto toDto(Booking booking){
        return new BookingResponseDto(
                booking.getId(),
                booking.getWorkoutClass().getId(),
                booking.getWorkoutClass().getName(),
                //booking.getWorkoutClass().getRoom().getName(),
                booking.getWorkoutClass().getRoom() != null
                        ? booking.getWorkoutClass().getRoom().getName()
                        : null,
                booking.getCreatedAt(),
                booking.getStatus()
        );
    }
}
