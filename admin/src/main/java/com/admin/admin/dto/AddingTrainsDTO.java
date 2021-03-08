package com.admin.admin.dto;

import lombok.Data;

@Data
public class AddingTrainsDTO {
   // private Long id;
    private Long trainId;
    private String name;
    private String startLocation;
    private String endLocation;
    private String departureTime;
    private Integer bogie;

}
