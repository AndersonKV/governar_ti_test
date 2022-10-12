package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "constructor_results")
@Entity
public class ConstructorResults {
    @Id
    private Long id;
    private Long race_id;
    private Long constructor_id;
    private Double points;
    private String status;

    public ConstructorResults() {
     }

    public ConstructorResults(Long id, Long race_id, Long constructor_id, Double points, String status) {
        this.id = id;
        this.race_id = race_id;
        this.constructor_id = constructor_id;
        this.points = points;
        this.status = status;
    }

    @Override
    public String toString() {
        return "constructor_results [id=" + this.getId() + ", race_id=" + this.getRace_id() + ", constructor_id=" + this.getConstructor_id() + ", points=" + this.getPoints() + ", status=" + this.getStatus()  + "]";
    }
}
