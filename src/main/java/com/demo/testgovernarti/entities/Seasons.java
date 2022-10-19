package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.net.URL;


@Getter
@Entity
@Table(name = "seasons")
@Setter
public class Seasons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String years;
    private String url;

    public Seasons() {

    }


    public Seasons(String years, String url) {
        this.years = years;
        this.url = url;
    }
}
