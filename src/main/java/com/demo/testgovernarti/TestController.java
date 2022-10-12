package com.demo.testgovernarti;

import com.demo.testgovernarti.entities.ConstructorResults;
import com.demo.testgovernarti.entities.ConstructorStandings;
import com.demo.testgovernarti.repository.ConstructorResultsRepository;
import com.demo.testgovernarti.repository.ConstructorStandingsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
class RapidinhoDTO {
    private Long id;
}

@RestController
@RequestMapping(value = "/api/v1")
public class TestController {
    @Autowired
    private ConstructorStandingsRepository constructorStandingsRepository;

    @Autowired
    private ConstructorResultsRepository constructorResultsRepository;

    @GetMapping(value = "/find_by_race_id/{id}")
    public List<ConstructorResults> test(@PathVariable("id") Long id) {
        List<ConstructorResults> listRace = this.constructorResultsRepository.findByRaceId(id);

        if (listRace.isEmpty()) {
            new IllegalStateException("id não encontrado");
        }

        return listRace;

    }


    @GetMapping
    public ConstructorStandings test2() {

        var constructorStandings = new ConstructorStandings();

        var id = constructorStandings.getId();
        var raceId = constructorStandings.getRace_id();
        var constructorId = constructorStandings.getConstructor_id();
        var points = constructorStandings.getPoints();
        var position = constructorStandings.getPosition();
        var positionText = constructorStandings.getPosition_text();
        var wins = constructorStandings.getWins();

        ConstructorStandings transformedCircuit = new ConstructorStandings(
                id, raceId, constructorId, points, position, positionText, wins
        );


        return transformedCircuit;
    }
}
