package com.cloudbees.models;

import lombok.Getter;
import lombok.Setter;


public class ReservationUpdateRequest {

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
    private int old_price;

    @Getter
    @Setter
    private int new_price;



    @Getter
    @Setter
    private Section old_section;

    @Getter
    @Setter
    private Section new_section;

    @Getter
    @Setter
    private long old_pnr;

    @Getter
    @Setter
    private long new_pnr;

    @Getter
    @Setter
    private long old_seat_no;

    @Getter
    @Setter
    private long new_seat_no;

    @Getter
    @Setter
    private long reservation_id;


}
