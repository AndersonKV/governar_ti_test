package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
@Getter
@Setter
public class Results {
    @Id
    private Long id;
    private Long race_id;

    private Long driverId;

    private Long constructorId;
    private String number;
    private String grid;
    private String position;
    private String position_text;
    private String position_order;

    private String points;
    private String laps;
    private String time;
    private String milliseconds;
    private String fastest_lap;
    private String rank;

    private String fastest_lap_time;
    private String fastest_lap_speed;
    private Long status_id;

    public Results() {

    }

    public Results(Long id, Long race_id, Long driverId, Long constructorId, String number, String grid, String position, String position_text, String position_order, String points, String laps, String time, String milliseconds, String fastest_lap, String rank, String fastest_lap_time, String fastest_lap_speed, Long status_id) {
        this.id = id;
        this.race_id = race_id;
        this.driverId = driverId;
        this.constructorId = constructorId;
        this.number = number;
        this.grid = grid;
        this.position = position;
        this.position_text = position_text;
        this.position_order = position_order;
        this.points = points;
        this.laps = laps;
        this.time = time;
        this.milliseconds = milliseconds;
        this.fastest_lap = fastest_lap;
        this.rank = rank;
        this.fastest_lap_time = fastest_lap_time;
        this.fastest_lap_speed = fastest_lap_speed;
        this.status_id = status_id;
    }
}
