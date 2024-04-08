package com.cloudbees.service;

import com.cloudbees.models.Reservation;
import com.cloudbees.models.Section;
import com.cloudbees.repository.ReservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeatReservationServiceTest {
    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private SeatReservationServiceImpl sts;

    @Test
    void viewReservedSeat() {
        Reservation res = new Reservation(
                2,
                1712521000,
                1712526061,
                1712526062,
                23456,
                1712526023,
                Section.B,
                232343,
                18
        );


        when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(res));
        Optional<Reservation> obj = sts.viewReservedSeat(2);
        Assertions.assertEquals(res.getSeatNo(), obj.get().getSeatNo());

    }
}