package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "drivers")
public class Drivers {
    @Id
    private Long id;
    private String driver_ref;
    private String number;
    private String code;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

    public Drivers() {

    }

    public Drivers(Long id, String driver_ref, String number, String code, String forename, String surname, String dob, String nationality, String url) {
        this.id = id;
        this.driver_ref = driver_ref;
        this.number = number;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.url = url;
    }




}
