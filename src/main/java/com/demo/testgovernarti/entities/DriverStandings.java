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
    private Long raceId;
    private Long driverId;
    private Double points;
    private Integer position;
    private String position_text;
    private Integer wins;

    public DriverStandings() {
    }

    public DriverStandings(Long id, Long raceId, Long driverId, Double points, Integer position, String position_text, Integer wins) {
        this.id = id;
        this.raceId = raceId;
        this.driverId = driverId;
        this.points = points;
        this.position = position;
        this.position_text = position_text;
        this.wins = wins;
    }




}
