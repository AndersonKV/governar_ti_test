package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "circuit")
@Entity
public class Circuit {
    @Id
    private Long id;
    private String circuit_ref;
    private String name;
    private String location;
    private String country;
    private Double lat;
    private Double lng;
    private String alt;
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


    @Override
    public String toString() {
        return "circuit [id=" + this.getId() + ", circuit_ref=" + getCircuit_ref() + ", name=" + this.getName() + ", location=" + getLocation() + ", country=" + getCountry() + ", lat=" + getLat() + ", lng=" + getLng() + ", alt=" + getAlt() + ", url=" + getUrl() + "]";
    }
}



