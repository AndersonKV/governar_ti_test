package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Getter
@Setter
@Entity
@Table(name = "lap_times")
public class LapTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long race_id;
    private Long driver_id;
    private String lap;
    private String position;
    private String time;
    private Double milliseconds;


    public LapTimes() {

    }

    public LapTimes(Long race_id, Long driver_id, String lap, String position, String time, double milliseconds) {
        this.race_id = race_id;
        this.driver_id = driver_id;
        this.lap = lap;
        this.position = position;
        this.time = time;
        this.milliseconds = milliseconds;
    }


    public static String[] fields() {
        return new String[] {
                "race_id",
                "driver_id",
                "lap",
                "position",
                "time",
                "milliseconds"
        };
    }

    public static String[] insertFields() {
        return new String[] {
                ":race_id",
                ":driver_id",
                ":lap",
                ":position",
                ":time",
                ":milliseconds"
        };
    }

}
