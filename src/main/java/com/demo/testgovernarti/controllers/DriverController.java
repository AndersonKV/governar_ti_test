package com.demo.testgovernarti.controllers;

import com.demo.testgovernarti.DTO.DriverDTO;
import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.Drivers;
import com.demo.testgovernarti.repository.ConstructorResultsRepository;
import com.demo.testgovernarti.repository.ConstructorStandingsRepository;
import com.demo.testgovernarti.repository.DriverStandingsRepository;
import com.demo.testgovernarti.repository.DriversRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DriverStandingsRepository driverStandingsRepository;


    @Autowired
    private DriversRepository driversRepository;

    @ApiOperation(value="should create user")
    @GetMapping(value = "drivers/winner/{wins}")
    public List<DriverDTO> findDriverWhoWinner(@PathVariable("wins") Integer wins) {
        List<DriverDTO> listDriverDTO = new ArrayList<>();

        List<DriverStandings> listWinners = this.driverStandingsRepository.findByWins(wins);

        listWinners.stream().forEach(listWinner -> {

            Optional<Drivers> driver = this.driversRepository.findById(listWinner.getDriver_id());

            DriverDTO driverDTO = new DriverDTO();

            driverDTO.setDriver_id(driver.get().getId());
            driverDTO.setName(driver.get().getForename());
            driverDTO.setDate_of_birth(driver.get().getDob());
            driverDTO.setFamily_name(driver.get().getSurname());
            driverDTO.setWins(wins);
            driverDTO.setNationality(driver.get().getNationality());
            driverDTO.setNumber(driver.get().getNumber());

            listDriverDTO.add(driverDTO);


        });

        return listDriverDTO;
    }

}
