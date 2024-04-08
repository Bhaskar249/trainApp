package com.cloudbees.repository;

import com.cloudbees.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SeatRepository extends JpaRepository<Seats, Long> {

    public Seats findBySeatNo(long seatNo);
}
