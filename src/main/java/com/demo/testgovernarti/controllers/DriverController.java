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




@Api(value="DRIVER CONTROLLER")
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @ApiOperation(value="deve retornar uma lista de pilotos com base na vitoria")
    @GetMapping(value = "drivers/winner/{wins}")
    public ResponseEntity findDriverWhoWinner(@PathVariable("wins") Integer wins) {
         return this.driverService.findDriverWhoWinner(wins);
    }

    @ApiOperation(value="deve retornar uma lista de pilotos com maior numero de construtores")
    @GetMapping(value = "drivers/teams")
    public ResponseEntity drivenGreatestNumberTeams() {
        return this.driverService.drivenGreatestNumberTeams();
    }


    @ApiOperation(value="deve retornar uma lista de pilotos com maior numero de construtores")
    @GetMapping(value = "drivers/wins-gap")
    public ResponseEntity driversWinsGap() {
        return this.driverService.driversWinsGap();
    }

}
