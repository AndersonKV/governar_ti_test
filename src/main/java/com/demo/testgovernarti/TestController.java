package com.demo.testgovernarti;

import com.demo.testgovernarti.entities.ConstructorStandings;
import com.demo.testgovernarti.repository.ConstructorStandingsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Getter
@Setter
class RapidinhoDTO {
    private Long id;
}
@RestController
@RequestMapping(name = "/filter")
public class TestController {
    @Autowired
    private ConstructorStandingsRepository constructorStandingsRepository;


    @PostMapping
    public Optional<ConstructorStandings> test(@RequestBody RapidinhoDTO RapidinhoDTO) {
       System.out.print(RapidinhoDTO.getId());
        return this.constructorStandingsRepository.findById(3l);

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
