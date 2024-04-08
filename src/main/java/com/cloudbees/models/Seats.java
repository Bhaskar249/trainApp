package com.cloudbees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter

    @Setter
    private long seatNo;

    @Getter
    @Setter
    private long train;

    @Getter
    @Setter
    private Section section;

}
