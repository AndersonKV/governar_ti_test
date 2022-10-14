package com.demo.testgovernarti.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListDriversWhoHadMoreConstructorsDTO {
    private Long driver_id;
    private String name;
    private String family_name;
    private String date_of_birth;
    private String nationality;
    private List<String> constructors;
    private Integer total;
}
