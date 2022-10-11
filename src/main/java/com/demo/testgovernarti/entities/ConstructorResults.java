package com.demo.testgovernarti.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructorResults {
    private Long id;
    private Long raceId;
    private Long constructorId;
    private Double points;
    private String status;

    public ConstructorResults() {
     }

    public ConstructorResults(Long id, Long raceId, Long constructorId, Double points, String status) {
        this.id = id;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ConstructorResults [id=" + this.getId() + ", raceId=" + this.getRaceId() + ", constructorId=" + this.getConstructorId() + ", points=" + this.getPoints() + ", status=" + this.getStatus()  + "]";
    }
}
