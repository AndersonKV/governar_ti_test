package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pit_stops")
public class PitStops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long race_id;
    private Long driver_id;
    private Integer stop;
    private Integer lap;
    private String time;
    private String duration;
    private Double milliseconds;

    public PitStops() {

    }


    public PitStops(Long race_id, Long driver_id, Integer stop, Integer lap, String time, String duration, Double milliseconds) {
        this.race_id = race_id;
        this.driver_id = driver_id;
        this.stop = stop;
        this.lap = lap;
        this.time = time;
        this.duration = duration;
        this.milliseconds = milliseconds;
    }

    @Override
    public String toString() {
        return "pit_stops [race_id " + this.getRace_id() + ", driver_id=" + this.getDriver_id() + ", stop=" + this.getStop() + ", lap=" + this.getLap() + ", time=" + this.getTime()  + ", duration=" + this.getDuration()  + ", milliseconds=" + this.getMilliseconds()  + "]";
    }
}
