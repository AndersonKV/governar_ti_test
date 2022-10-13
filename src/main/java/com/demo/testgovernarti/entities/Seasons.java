package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seasons")
@Getter
@Setter
public class Seasons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String url;

    public Seasons() {

    }

    public Seasons(String year, String url) {
        this.year = year;
        this.url = url;
    }
}
