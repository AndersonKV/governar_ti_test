package com.demo.testgovernarti.services;

import com.demo.testgovernarti.DTO.DriverDTO;
import com.demo.testgovernarti.DTO.ListDriversWhoHadMoreConstructorsDTO;
import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.Drivers;
import com.demo.testgovernarti.exception.ApiRequestException;
import com.demo.testgovernarti.repository.ConstructorsRepository;
import com.demo.testgovernarti.repository.DriverStandingsRepository;
import com.demo.testgovernarti.repository.DriversRepository;
import com.demo.testgovernarti.repository.ResultsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
class ListConstructors {
    private List<String> teams;
}

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


    public ResponseEntity findDriverWhoWinner(Integer wins) {
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

        return new ResponseEntity(listDriverDTO, HttpStatus.ACCEPTED);
    }


    public ResponseEntity drivenGreatestNumberTeams() {
        try {
            var listDrivers = this.driversRepository.findAll();
            List<ListDriversWhoHadMoreConstructorsDTO> listDriverDTO = new ArrayList<>();

            List<Integer> arr2 = new ArrayList<>();
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


            //Collections.sort(listDriverDTO..getTotal(), Collections.reverseOrder());
//            listDriverDTO.sort(Comparator.comparing(listDriverDTO::getTotal()).reversed());
//            listDriverDTO.sort(Comparator.comparing(listDriverDTO.get().getTotal()).reversed());
//

            listDriverDTO.sort(Comparator.comparing(ListDriversWhoHadMoreConstructorsDTO::getTotal).reversed());


            var firstNElementsList = listDriverDTO.stream().limit(10).collect(Collectors.toList());

            return new ResponseEntity(firstNElementsList, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());

        }
    }

}