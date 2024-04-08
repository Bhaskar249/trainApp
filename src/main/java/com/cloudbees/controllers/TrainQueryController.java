package com.cloudbees.controllers;

import com.cloudbees.models.Train;
import com.cloudbees.service.SearchTrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrainQueryController {

    @Autowired
    private SearchTrainServiceImpl trainService;
    @GetMapping("/welcome")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/search/{from}/{to}")
    public ResponseEntity<List<Train>> searchTrains(@PathVariable("from")String from, @PathVariable("to")String to)  {

         List<Train> trains=  trainService.searchTrainByToAndFrom(from,to);

         return new ResponseEntity<>(trains, HttpStatus.OK);


    }
}
