package com.cloudbees.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


public class ReservationRequest {
    @Getter
    @Setter
    private long from;
    @Getter
    @Setter
    private long to;
    @Getter
    @Setter

    private long user;
    @Getter
    @Setter

    private int price;
    @Getter
    @Setter

    private Section section;

    @Getter
    @Setter
    private long pnr;

    @Getter
    @Setter
    private long seat_no;


}
