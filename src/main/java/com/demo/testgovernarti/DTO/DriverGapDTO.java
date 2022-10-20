package com.demo.testgovernarti.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class DriverGapDTO  {
    private Long id;
    private String number;
    private String code;
    private String forename;
    private String surname;
    private String nationality;
    private String date_of_birth;

    private String firstWin;
    private String lastWin;
    private Long gap = 0l;

    public DriverGapDTO() {
    }



}
