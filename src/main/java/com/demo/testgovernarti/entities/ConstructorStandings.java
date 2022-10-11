package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructorStandings {
    private Long id;
    private Long raceId;
    private Long constructorId;
    private Double points;
    private Integer position;
    private String positionText;
    private Integer wins;

    public ConstructorStandings() {
    }

    public ConstructorStandings(Long id, Long raceId, Long constructorId, Double points, Integer position, String positionText, Integer wins) {
        this.id = id;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "ConstructorStandings [id=" + this.getId() + ", raceId=" + this.getRaceId() + ", constructorId=" + this.getConstructorId() + ", points=" + this.getPoints() + ", position=" + this.getPosition()  + ", positionText=" + this.getPositionText()  + ", wins=" + this.getWins()  + "]";
    }
}
