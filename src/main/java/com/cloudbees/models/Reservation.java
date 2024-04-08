package com.cloudbees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private long passenger;
    @Getter
    @Setter
    private long startlocaition;
    @Getter
    @Setter
    private long endlocation;
    @Getter
    @Setter
    private long distance;
    @Getter
    @Setter
    private long trainId;

    @Getter
    @Setter
    private Section section;

    @Getter
    @Setter
    private long seatNo;
    @Getter
    @Setter
    private int price;
}
