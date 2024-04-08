package com.cloudbees.service;

import com.cloudbees.models.Train;

import java.util.List;

public interface SearchTrainService {
    public List<Train> searchTrainByToAndFrom(String from, String to);
}
