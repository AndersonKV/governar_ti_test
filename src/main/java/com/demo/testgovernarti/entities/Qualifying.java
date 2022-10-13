package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "qualifying")
public class Qualifying {
    @Id
    private Long id;
    private Long race_id;
    private Long driver_id;
    private Long constructor_id;
    private Integer number;
    private Integer position;
    private String q1;
    private String q2;
    private String q3;

    public Qualifying() {

    }

    public Qualifying(Long id, Long race_id, Long driver_id, Long constructor_id, Integer number, Integer position, String q1, String q2, String q3) {
        this.id = id;
        this.race_id = race_id;
        this.driver_id = driver_id;
        this.constructor_id = constructor_id;
        this.number = number;
        this.position = position;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    @Override
    public String toString() {
        return "qualifying [id " + this.getId() + ", race_id=" + this.getRace_id() + ", driver_id=" + this.getDriver_id() + ", constructor_id=" + this.getConstructor_id() + ", number=" + this.getNumber()  + ", position=" + this.getPosition()  + ", q1=" + this.getQ1()  + ", q2=" + this.getQ2()  + ", q3=" + this.getQ3()  + "]";
    }
}
