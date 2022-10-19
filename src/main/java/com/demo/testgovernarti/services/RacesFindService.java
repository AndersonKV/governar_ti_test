package com.demo.testgovernarti.services;

import com.demo.testgovernarti.DTO.DriverSeasonAndRoundDTO;
import com.demo.testgovernarti.DTO.ListDriversSeasonAndRound;
import com.demo.testgovernarti.DTO.ListDriversWhoHadMoreConstructorsDTO;
import com.demo.testgovernarti.entities.*;
import com.demo.testgovernarti.exception.ApiRequestException;
import com.demo.testgovernarti.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class RacesFindService {
    @Autowired
    private RacesRepository racesRepository;

    @Autowired
    private CircuitRepository circuitRepository;

    @Autowired
    private DriverStandingsRepository driverStandingsRepository;

    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private ResultsRepository resultsRepository;

    @Autowired
    private ConstructorsRepository constructorsRepository;


    public ResponseEntity findDriversBySeasonsAndRounds(String season, Integer round) {
        try {
            var races = this.racesRepository.findByYearAndRound(season, round);

            if (races.isEmpty()) {
                throw new ApiRequestException("Nenhum dado foi encontrado com esse ano e etapa");
            }

            var circuit = this.circuitRepository.findById(races.get().getCircuit_id());

            if (circuit.isEmpty()) {
                throw new ApiRequestException("circuito não encontrado");
            }

            List<DriverStandings> listDriversStandings = this.driverStandingsRepository.findByRaceId(races.get().getId());

            List<DriverSeasonAndRoundDTO> driverSeasonAndRoundDTOS = new ArrayList<>();

            listDriversStandings.stream().forEach(driver -> {

                Optional<Drivers> getDriver = this.driversRepository.findById(driver.getDriverId());
                List<Results> results = this.resultsRepository.findByDriverId(getDriver.get().getId());
                Optional<Constructors> constructors = this.constructorsRepository.findById(results.get(1).getDriverId());


                DriverSeasonAndRoundDTO driverDTO = new DriverSeasonAndRoundDTO();

                if (constructors.isPresent()) {
                    driverDTO.setConstructors(constructors.get().getName());
                    driverDTO.setNationality(getDriver.get().getNationality());
                }

                driverDTO.setDriver_id(getDriver.get().getId());
                driverDTO.setName(getDriver.get().getForename());
                driverDTO.setDate_of_birth(getDriver.get().getDob());
                driverDTO.setFamily_name(getDriver.get().getSurname());


                driverSeasonAndRoundDTOS.add(driverDTO);

            });


            var listDriversSeasonAndRound = new ListDriversSeasonAndRound();

            listDriversSeasonAndRound.setCircuit_id(races.get().getCircuit_id());
            listDriversSeasonAndRound.setDate(races.get().getDate());
            listDriversSeasonAndRound.setRace_id(races.get().getId());
            listDriversSeasonAndRound.setYear(races.get().getYear());
            listDriversSeasonAndRound.setRace_name(races.get().getName());
            listDriversSeasonAndRound.setRound(races.get().getRound());
            listDriversSeasonAndRound.setCircuit_name(circuit.get().getCircuit_ref());
            listDriversSeasonAndRound.setCountry(circuit.get().getCountry());
            listDriversSeasonAndRound.setLocation(circuit.get().getLocation());
            listDriversSeasonAndRound.setCircuit_name(circuit.get().getName());
            listDriversSeasonAndRound.setCircuit_ref(circuit.get().getCircuit_ref());

            listDriversSeasonAndRound.setList(driverSeasonAndRoundDTOS);

            return new ResponseEntity(listDriversSeasonAndRound, HttpStatus.ACCEPTED);
            //return new ResponseEntity( HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }

}

