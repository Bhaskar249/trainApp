package com.cloudbees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Entity
public class SeatAvailibility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter

    @Setter
    private long id                          ;

    @Getter
    @Setter
    private long trainNo                    ;

    @Getter
    @Setter
    private int total_seats                  ;

    @Getter
    @Setter
    private int total_seats_in_section_A     ;

    @Getter
    @Setter
    private int total_seats_in_section_B     ;

    @Getter
    @Setter
    private int available_seats_in_section_A ;

    @Getter
    @Setter
    private int available_seats_in_section_B;

}
