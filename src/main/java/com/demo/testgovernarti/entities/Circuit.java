package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.math.BigDecimal;


@Getter
@Setter
public class Circuit {
    private Long circuitId;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
    private Double lat;
    private Double lng;
    private short alt;
    private String url;

    public Circuit() {

    }

    public Circuit(Long circuitId, String circuitRef, String name, String location, String country, Double lat, Double lng, short alt, String url) {
        this.circuitId = circuitId;
        this.circuitRef = circuitRef;
        this.name = name;
        this.location = location;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.url = url;
    }

//    public static String[] fields() {
//        return new String[]{"circuitId", "circuitRef", "name", "location", "country", "lat", "lng", "alt", "url"};
//    }

    @Override
    public String toString() {
        return "Circuit [circuitId=" + this.getCircuitId() + ", circuitRef=" + getCircuitRef() + ", name=" + this.getName() + ", location=" + getLocation() + ", country=" + getCountry() + ", lat=" + getLat() + ", lng=" + getLng() + ", alt=" + getAlt() + ", url=" + getUrl() + "]";
    }
}



