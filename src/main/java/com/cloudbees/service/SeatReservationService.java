package com.cloudbees.service;

import com.cloudbees.exceptions.PersistenceLayerException;
import com.cloudbees.models.Reservation;
import com.cloudbees.models.ReservationRequest;
import com.cloudbees.models.ReservationUpdateRequest;

import java.util.Optional;

public interface SeatReservationService {
    public Reservation reserveSeat(ReservationRequest req) throws PersistenceLayerException;
    public Optional<Reservation> viewReservedSeat(long id);
    public Reservation updateReservation(ReservationUpdateRequest req) throws PersistenceLayerException;
    public String deleteReservation(Reservation req) throws PersistenceLayerException;
    public Reservation viewReservedSeatByUser(long userID) throws PersistenceLayerException;
}
