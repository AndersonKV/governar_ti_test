package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "driver_standings")
public class DriverStandings {
    @Id
    private Long id;
    private Long race_id;
    private Long driver_id;
    private Double points;
    private Integer position;
    private String position_text;
    private Integer wins;

    public DriverStandings() {
    }

    public DriverStandings(Long id, Long race_id, Long driver_id, Double points, Integer position, String position_text, Integer wins) {
        this.id = id;
        this.race_id = race_id;
        this.driver_id = driver_id;
        this.points = points;
        this.position = position;
        this.position_text = position_text;
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "driver_standings [id=" + this.getId() + ", race_id=" + this.getRace_id() + ", driver_id=" + this.getDriver_id() + ", points=" + this.getPoints() + ", position=" + this.getPosition()  + ", position_text=" + this.getPosition_text()  + ", wins=" + this.getWins()  + "]";
    }
}
