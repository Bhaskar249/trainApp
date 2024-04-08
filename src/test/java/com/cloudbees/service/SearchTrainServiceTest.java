package com.cloudbees.service;

import com.cloudbees.models.Location;
import com.cloudbees.models.Train;
import com.cloudbees.repository.LocationRepository;
import com.cloudbees.repository.TrainRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ComponentScan(basePackages = {"com.cloudbees.repository", "com.cloudbees.service", "com.cloudbees.models"})
class SearchTrainServiceTest {

    @Mock
    LocationRepository locationRepository;
    @Mock
    TrainRepository trainRepo;

    @InjectMocks
    @Spy
    private SearchTrainServiceImpl sts;


    @Test
    public void testSearchTrainByToAndFrom() {
        Location start = new Location(1712526061, "London");
        Location end = new Location(1712526062, "France");
        List<Train> list = new ArrayList<>();
        list.add(new Train(1712526023,
                "Bullet train",
                1712526061,
                1712526062,
                1712526060,
                1712526060,
                23456));
        when(locationRepository.findByCity("London")).thenReturn(start);
        when(locationRepository.findByCity("France")).thenReturn(end);
        when(trainRepo.findByStartlocationAndEndlocation(anyLong(), anyLong())).thenReturn(list);

        List res = sts.searchTrainByToAndFrom("London", "France");
        Assertions.assertEquals(1, res.size());

    }
}