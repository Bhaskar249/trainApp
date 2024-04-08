package com.cloudbees.service;

import com.cloudbees.models.Train;
import com.cloudbees.repository.LocationRepository;
import com.cloudbees.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTrainService {


    @Autowired
    private TrainRepository trainRepo;

    @Autowired
    private LocationRepository locationRepository;

    public List<Train> searchTrainByToAndFrom(String from, String to) {
        long start = locationRepository.findByCity(from).getId();
        long end = locationRepository.findByCity(to).getId();

        return trainRepo.findByStartlocationAndEndlocation(start, end);
    }
}
