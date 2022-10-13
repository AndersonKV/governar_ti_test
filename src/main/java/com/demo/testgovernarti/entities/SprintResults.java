package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sprint_results")
@Getter
@Setter
public class SprintResults {
    @Id
    private Long id;
    private Long race_id;
    private Long driver_id;
    private Long constructor_id;
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
    private String fastest_lap_time;
    private String status_id;

    public SprintResults() {

    }

    public SprintResults(Long id, Long race_id, Long driver_id, Long constructor_id, String number, String grid, String position, String position_text, String position_order, String points, String laps, String time, String milliseconds, String fastest_lap, String fastest_lap_time, String status_id) {
        this.id = id;
        this.race_id = race_id;
        this.driver_id = driver_id;
        this.constructor_id = constructor_id;
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
        this.fastest_lap_time = fastest_lap_time;
        this.status_id = status_id;
    }
}
