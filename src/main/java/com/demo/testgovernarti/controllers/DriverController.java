package com.demo.testgovernarti.controllers;

import com.demo.testgovernarti.DTO.DriverDTO;
import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.Drivers;
import com.demo.testgovernarti.repository.ConstructorResultsRepository;
import com.demo.testgovernarti.repository.ConstructorStandingsRepository;
import com.demo.testgovernarti.repository.DriverStandingsRepository;
import com.demo.testgovernarti.repository.DriversRepository;
import com.demo.testgovernarti.services.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Api(value="API REST CREATE USER")
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1")
public class DriverController {
    @Autowired
    private ConstructorStandingsRepository constructorStandingsRepository;

    @Autowired
    private ConstructorResultsRepository constructorResultsRepository;

    @Autowired
    private DriverService driverService;

    @ApiOperation(value="should create user")
    @GetMapping(value = "drivers/winner/{wins}")
    public ResponseEntity findDriverWhoWinner(@PathVariable("wins") Integer wins) {
         return this.driverService.findDriverWhoWinner(wins);
    }


    @GetMapping(value = "drivers/teams")
    public ResponseEntity drivenGreatestNumberTeams() {
        return this.driverService.drivenGreatestNumberTeams();
    }
}
