package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Circuit {
    private Long id;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private Double lat;
    private Double lng;
    private String alt;
    private String url;



    public Circuit() {

    }

    public Circuit(Long id, String circuitRef, String name, String location, String country, Double lat, Double lng, String alt, String url) {
        this.id = id;
        this.circuitRef = circuitRef;
        this.name = name;
        this.location = location;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.url = url;
    }


    @Override
    public String toString() {
        return "Circuit [id=" + this.getId() + ", circuitRef=" + getCircuitRef() + ", name=" + this.getName() + ", location=" + getLocation() + ", country=" + getCountry() + ", lat=" + getLat() + ", lng=" + getLng() + ", alt=" + getAlt() + ", url=" + getUrl() + "]";
    }
}



