package com.cloudbees.repository;

import com.cloudbees.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends JpaRepository<Location, Long> {

    public Location findByCity(String name);
}
