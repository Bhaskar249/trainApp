package com.cloudbees.repository;

import com.cloudbees.models.SeatAvailibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatAvailibilityRepository  extends JpaRepository<SeatAvailibility, Long> {

    public SeatAvailibility findByTrainNo(long trainNo);
}
