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
public class Races  {
    @Id
    private Long id;
    private String year;
    private Integer round;
    private Long circuit_id;
    private String name;
    private String date;
    private String time;
    private String url;
    private String fp1_date;
    private String fp1_time;
    private String fp2_date;
    private String fp2_time;
    private String fp3_date;
    private String fp3_time;
    private String qualify_date;
    private String qualify_time;
    private String sprint_date;
    private String sprint_time;

    public Races() {

    }

    public Races(Long id, String year, Integer round, Long circuit_id, String name, String date, String time, String url, String fp1_date, String fp1_time, String fp2_date, String fp2_time, String fp3_date, String fp3_time, String qualify_date, String qualify_time, String sprint_date, String sprint_time) {
        this.id = id;
        this.year = year;
        this.round = round;
        this.circuit_id = circuit_id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.url = url;
        this.fp1_date = fp1_date;
        this.fp1_time = fp1_time;
        this.fp2_date = fp2_date;
        this.fp2_time = fp2_time;
        this.fp3_date = fp3_date;
        this.fp3_time = fp3_time;
        this.qualify_date = qualify_date;
        this.qualify_time = qualify_time;
        this.sprint_date = sprint_date;
        this.sprint_time = sprint_time;
    }

    @Override
    public String toString() {
        return "races [id " + this.getId() + ", year=" + this.getYear() + ", round=" + this.getRound() + ", circuit_id=" + this.getCircuit_id() +
                ", name=" + this.getName()  + ", date=" + this.getDate()  + ", time=" + this.getTime()  + ", url=" + this.getUrl() +
                ", fp1_date=" + this.getFp2_date()  +  ", fp1_time=" + this.getFp1_time()  +  ", fp2_date=" + this.getFp1_date()  +  ", fp2_time=" + this.getFp2_time()  +  ", fp3_date=" + this.getFp3_date()  +
                ", fp3_time=" + this.getFp3_time()  +  ", qualify_date=" + this.getQualify_date()  +  ", qualify_time=" + this.getQualify_time()  +  ", sprint_date=" + this.getSprint_date() +  ", sprint_time=" + this.getSprint_time()  + "]";
    }
}
