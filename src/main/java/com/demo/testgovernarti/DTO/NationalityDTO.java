package com.demo.testgovernarti.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NationalityDTO {
    private String nationality;
    private Integer wins;

    public NationalityDTO( ) {

    }

    public NationalityDTO(String nationality, Integer wins) {
        this.nationality = nationality;
        this.wins = wins;
    }
}
