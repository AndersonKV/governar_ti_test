package com.demo.testgovernarti.controllers;

import com.demo.testgovernarti.services.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @ApiOperation(value="deve retornar uma lista com 10 maiores gaps entre a primeira e ultima vitoria")
    @GetMapping(value = "drivers/wins-gap")
    public ResponseEntity driversWinsGap() {
        return this.driverService.driversWinsGap();
    }


    @ApiOperation(value="deve retornar o pais que mais venceu")
    @GetMapping(value = "nationalities/wins")
    public ResponseEntity nationalityWins() {
        return this.driverService.nationalityWins();
    }

}
