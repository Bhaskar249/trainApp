package com.cloudbees.service;

import com.cloudbees.exceptions.PersistenceLayerException;
import com.cloudbees.models.*;
import com.cloudbees.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ComponentScan(basePackages = {"com.cloudbees.repository"})
public class SeatReservationServiceImpl implements SeatReservationService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatAvailibilityRepository seatAvailibilityRepository;


    @Autowired
    private SeatRepository seatRepository;


    @org.springframework.transaction.annotation.Transactional(rollbackFor = PersistenceLayerException.class)
    public Reservation reserveSeat(ReservationRequest req) throws PersistenceLayerException {
        try {
            Train train = trainRepository.findByPnr(req.getPnr());

            SeatAvailibility sa = seatAvailibilityRepository.findByTrainNo(req.getPnr());

            Seats st = seatRepository.findBySeatNo(req.getSeat_no());

            Reservation res = reservationRepository.findBySeatNo(st.getSeatNo());

            if (res == null && train != null) {
                res = new Reservation();
                res.setTrainId(train.getPnr());
                res.setSection(st.getSection());
                res.setSeatNo(req.getSeat_no());
                res.setPrice(req.getPrice());
                res.setDistance(train.getDistance());
                res.setStartlocaition(req.getFrom());
                res.setEndlocation(req.getTo());
                res.setPassenger(req.getUser());

            }

            System.out.println(res.getStartlocaition() + "******");
            res = reservationRepository.save(res);
            return res;
        } catch (Exception e) {
            throw new PersistenceLayerException(e.getMessage());
        }

    }

    public Optional<Reservation> viewReservedSeat(long id) {
        return reservationRepository.findById(id);
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = PersistenceLayerException.class)
    public Reservation updateReservation(ReservationUpdateRequest req) throws PersistenceLayerException {
        try {
            Train old_train = trainRepository.findByPnr(req.getOld_pnr());
            Train new_train = trainRepository.findByPnr(req.getNew_pnr());


            Seats old_st = seatRepository.findBySeatNo(req.getOld_seat_no());
            Seats new_st = seatRepository.findBySeatNo(req.getNew_seat_no());

            Reservation old_res = reservationRepository.findBySeatNo(old_st.getSeatNo());

            Reservation new_res = null;
            if (old_res != null) {
                new_res = new Reservation();
                new_res = new Reservation();
                new_res.setTrainId(new_train.getPnr());
                new_res.setSection(new_st.getSection());
                new_res.setSeatNo(new_st.getSeatNo());
                new_res.setPrice(req.getNew_price());
                new_res.setDistance(new_train.getDistance());
                new_res.setStartlocaition(req.getFrom());
                new_res.setEndlocation(req.getTo());
                new_res.setPassenger(req.getUser());
                reservationRepository.save(new_res);
            }
            reservationRepository.deleteById(old_res.getId());

            return new_res;
        } catch (Exception e) {
            throw new PersistenceLayerException(e.getMessage());
        }

    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = PersistenceLayerException.class)
    public String deleteReservation(Reservation req) throws PersistenceLayerException {


        try {
            Reservation res = reservationRepository.findBySeatNo(req.getSeatNo());
            if (res != null) {
                reservationRepository.deleteById(res.getId());
                return "Deleted successfully";
            }
        } catch (Exception e) {
            throw new PersistenceLayerException(e.getMessage());
        }
        return null;
    }

    public Reservation viewReservedSeatByUser(long userID) throws PersistenceLayerException {
        try {
            Reservation res = reservationRepository.findByPassenger(userID);
            return res;
        } catch (Exception e) {
            throw new PersistenceLayerException(e.getMessage());
        }
    }
}
