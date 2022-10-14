package com.demo.testgovernarti.DTO;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;

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
    private List<String> teams;
}
