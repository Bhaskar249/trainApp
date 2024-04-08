package com.cloudbees.repository;

import com.cloudbees.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    Train findByPnr(long pnr);

    List<Train> findByStartlocationAndEndlocation(long start, long end);


}