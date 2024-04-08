package com.cloudbees.repository;

import com.cloudbees.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    public Reservation findBySeatNo(long seat_no);

    public Optional<Reservation> findById(long id);

    public Reservation findByPassenger(long id);

}
