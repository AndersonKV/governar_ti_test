package com.demo.testgovernarti.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTO {
    private Long driver_id;
    private String name;
    private String family_name;
    private String date_of_birth;
    private Integer wins;
    private String nationality;
    private String number;

}
