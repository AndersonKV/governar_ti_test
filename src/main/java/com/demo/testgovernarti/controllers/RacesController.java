package com.demo.testgovernarti.controllers;

import com.demo.testgovernarti.DTO.DriverDTO;
import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.Drivers;
import com.demo.testgovernarti.entities.Races;
import com.demo.testgovernarti.repository.*;
import com.demo.testgovernarti.services.RacesFindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(value = "RACES CONTROLLER")
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1")
public class RacesController {

    @Autowired
    private RacesFindService racesFindService;

    @ApiOperation(value = "deve retorna uma lista de pilotos com base no ano e etapa")
    @GetMapping(value = "races/{seasons}/{round}")
    public ResponseEntity findDriversBySeasonsAndRounds(@PathVariable("seasons") String seasons, @PathVariable("round") Integer round) {
          return this.racesFindService.findDriversBySeasonsAndRounds(seasons, round);
    }



}
