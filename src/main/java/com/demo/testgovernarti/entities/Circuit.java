package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;


@Getter
@Setter
@Entity
@Table(name = "circuit")
public class Circuit {
    @Id
    private Long id;

    @Column(name = "circuit_ref")
    private String circuit_ref;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "alt")
    private String alt;

    @Column(name = "url")
    private String url;


    public Circuit() {

    }

    public Circuit(Long id, String circuit_ref, String name, String location, String country, Double lat, Double lng, String alt, String url) {
        this.id = id;
        this.circuit_ref = circuit_ref;
        this.name = name;
        this.location = location;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.url = url;
    }




}



