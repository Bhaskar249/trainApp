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
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long pnr;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private long startlocation;
    @Getter
    @Setter
    private long endlocation;
    @Getter
    @Setter
    private long start_time;
    @Getter
    @Setter
    private long end_time;

    @Getter
    @Setter
    private long distance;
}
