package com.demo.testgovernarti.services;

import com.demo.testgovernarti.DTO.*;
import com.demo.testgovernarti.entities.Drivers;
import com.demo.testgovernarti.exception.ApiRequestException;
import com.demo.testgovernarti.repository.*;
import com.demo.testgovernarti.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class DriverService {

    @Autowired
    private DriverStandingsRepository driverStandingsRepository;

    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private ResultsRepository resultsRepository;

    @Autowired
    private ConstructorsRepository constructorsRepository;

    @Autowired
    private RacesRepository racesRepository;


    @Autowired
    private Utils util;

    public ResponseEntity findDriverWhoWinner(Integer wins) {
        try {

            List<DriverDTO> listDriverDTO = new ArrayList<>();

            var listWinners = this.driverStandingsRepository.findByWins(wins);

            Arrays.stream(listWinners).forEach(listDriversStandings -> {

                Optional<Drivers> driver = this.driversRepository.findById(listDriversStandings);


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

            return new ResponseEntity(listDriverDTO, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }


    public ResponseEntity driversWinsGap() {
        try {
            var getAllDriversWhoWon = this.resultsRepository.getFirstPositionOne();


            var distinctResultsId = getAllDriversWhoWon
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());


            List<DriverGapDTO> initialListDrivers = new ArrayList();

            // pega todas as vitorias do piloto
            distinctResultsId.stream().forEach(listWinner -> {

                //  System.out.println(listWinner.getDriverId() + "id" + "\n");
                var listWithDriversWhoWon = this.resultsRepository.findByDriverIdAndPositionOne(listWinner.getDriverId());

                var getDrivers = this.driversRepository.findById(listWinner.getDriverId());

                var driverGapDTO = new DriverGapDTO();

                //::SETA TODAS AS INFO DO PILOTO:://
                driverGapDTO.setId(getDrivers.get().getId());
                driverGapDTO.setForename(getDrivers.get().getForename());
                driverGapDTO.setNumber(getDrivers.get().getNumber());
                driverGapDTO.setCode(getDrivers.get().getCode());
                driverGapDTO.setSurname(getDrivers.get().getSurname());
                driverGapDTO.setNationality(getDrivers.get().getNationality());
                driverGapDTO.setDate_of_birth(getDrivers.get().getDob());


                //lista de data de cada vitoria
                List<String> dateList = new ArrayList();

                //pega todas as vitorias do piloto com race_id
                listWithDriversWhoWon.stream().forEach(races -> {
                    var race = this.racesRepository.findById(races.getRace_id());

                    dateList.add(race.get().getDate());
                });

                Collections.reverse(dateList);

                if (dateList.size() >= 2) {

                    try {
                        driverGapDTO.setGap(this.util.getGapDays(dateList.get(0), dateList.get(1)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    driverGapDTO.setFirstWin(dateList.get(0));
                    driverGapDTO.setLastWin(dateList.get(1));
                }

                initialListDrivers.add(driverGapDTO);
            });


            List<DriverGapDTO> item = initialListDrivers.stream().filter(this.util.distinctByKey(DriverGapDTO::getId)).collect(Collectors.toList());

            item.sort(Comparator.comparing(DriverGapDTO::getGap).reversed());

             var first = item.stream().limit(10).collect(Collectors.toList());

            return new ResponseEntity(first, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }



    public ResponseEntity drivenGreatestNumberTeams() {
        try {
            var listDrivers = this.driversRepository.findAll();

            List<ListDriversWhoHadMoreConstructorsDTO> listDriverDTO = new ArrayList<>();

            //lista de pilotos
            listDrivers.stream().forEach(driver -> {
                var populateDrivers = new ListDriversWhoHadMoreConstructorsDTO();

                populateDrivers.setName(driver.getForename());
                populateDrivers.setDriver_id(driver.getId());
                populateDrivers.setFamily_name(driver.getSurname());
                populateDrivers.setDate_of_birth(driver.getDob());
                populateDrivers.setNationality(driver.getNationality());

                var listConstructorsFromDriver = this.resultsRepository.findConstructorsIdAndDriverId(driver.getId());

                List<String> listNamesConstructors = new ArrayList<>();
                populateDrivers.setTotal(listConstructorsFromDriver.length);

                //lista de construtores
                Arrays.stream(listConstructorsFromDriver).forEach(constructors -> {
                    var getConstructor = this.constructorsRepository.findById(constructors);
                    listNamesConstructors.add(getConstructor.get().getName());
                });

                populateDrivers.setConstructors(listNamesConstructors);

                listDriverDTO.add(populateDrivers);
            });


            listDriverDTO.sort(Comparator.comparing(ListDriversWhoHadMoreConstructorsDTO::getTotal).reversed());

            List<ListDriversWhoHadMoreConstructorsDTO> firstTenElements = listDriverDTO.stream().limit(10).collect(Collectors.toList());

            return new ResponseEntity(firstTenElements, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }


    public ResponseEntity nationalityWins() {
        try {
            var listDrivers = this.driversRepository.findByNationality();
            List<NationalityDTO> listWins = new ArrayList<>();

            Arrays.stream(listDrivers).forEach(e -> {
                var count = this.driversRepository.countNationality(e);
                listWins.add(new NationalityDTO(e, count));

            });

            listWins.sort(Comparator.comparing(NationalityDTO::getWins).reversed());

            return new ResponseEntity(listWins, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }


}