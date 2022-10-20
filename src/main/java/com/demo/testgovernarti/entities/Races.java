package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "races")
public class Races {
    @Id
    private Long id;
    private String years;
    private Integer round;
    private Long circuitId;
    private String name;
    private String date;
    private String time;
    private String url;
    private String fp1Date;
    private String fp1Time;
    private String fp2Date;
    private String fp2Time;
    private String fp3Date;
    private String fp3Time;
    private String qualifyDate;
    private String qualifyTime;
    private String sprintDate;
    private String sprintTime;

    public Races() {

    }


    public Races(Long id, String years, Integer round, Long circuitId, String name, String date, String time, String url, String fp1Date, String fp1Time, String fp2Date, String fp2Time, String fp3Date, String fp3Time, String qualifyDate, String qualifyTime, String sprintDate, String sprintTime) {
        this.id = id;
        this.years = years;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.url = url;
        this.fp1Date = fp1Date;
        this.fp1Time = fp1Time;
        this.fp2Date = fp2Date;
        this.fp2Time = fp2Time;
        this.fp3Date = fp3Date;
        this.fp3Time = fp3Time;
        this.qualifyDate = qualifyDate;
        this.qualifyTime = qualifyTime;
        this.sprintDate = sprintDate;
        this.sprintTime = sprintTime;
    }
}
