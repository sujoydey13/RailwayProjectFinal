package com.admin.admin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Trains {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long trainId;
    private String name;
    private String startLocation;
    private String endLocation;
    private String departureTime;
    private Integer bogie;
}
