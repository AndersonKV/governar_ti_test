package com.demo.testgovernarti.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ListDriversSeasonAndRound {
    private Long race_id;
    private String year;
    private Long circuit_id;
    private String race_name;
    private String date;
    private Integer round;
    private String circuit_ref;
    private String country;
    private String location;
    private String circuit_name;
    private List<DriverSeasonAndRoundDTO> list;
 }
