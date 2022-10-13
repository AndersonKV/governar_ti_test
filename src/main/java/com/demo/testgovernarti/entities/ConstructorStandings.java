package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "constructor_standings")
@Entity
public class ConstructorStandings {
    @Id
    private Long id;

    private Long race_id;

    private Long constructor_id;

    private Double points;

    private Integer position;

    private String position_text;

    private Integer wins;

    public ConstructorStandings() {
    }

    public ConstructorStandings(Long id, Long race_id, Long constructor_id, Double points, Integer position, String position_text, Integer wins) {
        this.id = id;
        this.race_id = race_id;
        this.constructor_id = constructor_id;
        this.points = points;
        this.position = position;
        this.position_text = position_text;
        this.wins = wins;
    }

}


