package com.demo.testgovernarti.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDriversPosition {
    private String position;
    private Long driverId;

    public ResultDriversPosition() {

    }
    public ResultDriversPosition(String position, Long driverId) {
        this.position = position;
        this.driverId = driverId;
    }
}
