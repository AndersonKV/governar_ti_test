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

@Api(value = "API REST CREATE USER")
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1")
public class RacesController {

//    @Autowired
//    private ConstructorStandingsRepository constructorStandingsRepository;
//
//    @Autowired
//    private ConstructorResultsRepository constructorResultsRepository;
//
//    @Autowired
//    private DriverStandingsRepository driverStandingsRepository;
//
//    @Autowired
//    private RacesRepository racesRepository;
//
//    @Autowired
//    private DriversRepository driversRepository;
//

    @Autowired
    private RacesFindService racesFindService;


    @ApiOperation(value = "should create user")
    @GetMapping(value = "races/{seasons}/{round}")
    public ResponseEntity findRaces(@PathVariable("seasons") String seasons, @PathVariable("round") Integer round) {
          return this.racesFindService.findDriversBySeasonsAndRounds(seasons, round);
        //List<DriverDTO> listDriverDTO = new ArrayList<>();

        //        List<DriverStandings> listWinners = this.driverStandingsRepository.findByWins(wins);
//
//        listWinners.stream().forEach(listWinner -> {
//
//            Optional<Drivers> driver = this.driversRepository.findById(listWinner.getDriver_id());
//
//            DriverDTO driverDTO = new DriverDTO();
//
//            driverDTO.setDriver_id(driver.get().getId());
//            driverDTO.setName(driver.get().getForename());
//            driverDTO.setDate_of_birth(driver.get().getDob());
//            driverDTO.setFamily_name(driver.get().getSurname());
//            driverDTO.setWins(wins);
//            driverDTO.setNationality(driver.get().getNationality());
//            driverDTO.setNumber(driver.get().getNumber());
//
//            listDriverDTO.add(driverDTO);
//
//
//        });
//
//        return listDriverDTO;
    }

}
