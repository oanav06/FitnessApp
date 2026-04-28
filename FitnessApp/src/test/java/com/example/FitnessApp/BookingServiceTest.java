package com.example.FitnessApp;

import com.example.FitnessApp.model.enums.BookingStatus;
import com.example.FitnessApp.model.dto.BookingRequestDto;
import com.example.FitnessApp.model.dto.BookingResponseDto;
import com.example.FitnessApp.model.entities.Booking;
import com.example.FitnessApp.model.entities.WorkoutClass;
import com.example.FitnessApp.repository.BookingRepository;
import com.example.FitnessApp.repository.WorkoutClassRepository;
import com.example.FitnessApp.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private WorkoutClassRepository workoutClassRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void createBooking_success() {
        // given
        BookingRequestDto requestDto = new BookingRequestDto(1L,  null);

        WorkoutClass workoutClass = new WorkoutClass();
        workoutClass.setId(1L);
        workoutClass.setName("Yoga");

        Booking booking = new Booking();
        booking.setId(1L);
        booking.setWorkoutClass(workoutClass);
        booking.setCreatedAt(LocalDate.now());
        booking.setStatus(BookingStatus.ONHOLD);

        when(workoutClassRepository.findById(1L)).thenReturn(Optional.of(workoutClass));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        // when
        BookingResponseDto responseDto = bookingService.createBooking(requestDto);

        // then
        assertNotNull(responseDto);
        assertEquals(1L, responseDto.id());
        assertEquals(1L, responseDto.workoutClassId());
        assertEquals("Yoga", responseDto.workoutClassName());
        assertEquals(BookingStatus.ONHOLD, responseDto.status());

        verify(workoutClassRepository).findById(1L);
        verify(bookingRepository).save(any(Booking.class));
    }


}