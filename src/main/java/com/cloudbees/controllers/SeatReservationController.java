package com.cloudbees.controllers;

import com.cloudbees.exceptions.PersistenceLayerException;
import com.cloudbees.models.Reservation;
import com.cloudbees.models.ReservationRequest;
import com.cloudbees.models.ReservationUpdateRequest;
import com.cloudbees.service.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
@RequestMapping("api/v1")
public class SeatReservationController {

    @Autowired
    private SeatReservationService seatReservationService;

    @PostMapping("/reservation/add")
    public ResponseEntity<Reservation> reserveSeat(@RequestBody ReservationRequest req) throws PersistenceLayerException {
        Reservation res = seatReservationService.reserveSeat(req);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/reservation/view/{ticket_id}")
    public ResponseEntity<Reservation> viewSeatReservation(@PathVariable("ticket_id") long id) {
        Optional<Reservation> res = seatReservationService.viewReservedSeat(id);

        return new ResponseEntity<>(res.get(), HttpStatus.OK);
    }

    @PostMapping("/reservation/view")
    public ResponseEntity<Reservation> viewSeatReservationByUser(@RequestBody long userID) throws PersistenceLayerException {
        Reservation res = seatReservationService.viewReservedSeatByUser(userID);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/reservation/update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody ReservationUpdateRequest req) throws PersistenceLayerException {
        Reservation res = seatReservationService.updateReservation(req);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/reservation/delete")
    public ResponseEntity<String> deleteReservation(@RequestBody Reservation req) throws PersistenceLayerException {
        String res = seatReservationService.deleteReservation(req);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
