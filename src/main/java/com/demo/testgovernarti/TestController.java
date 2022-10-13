package com.demo.testgovernarti;

import com.demo.testgovernarti.entities.ConstructorResults;
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
    public String[] test2() {

        return new String[]{"id",
                "year", "round circuit_id", "name", "date",
                "time", "url", "fp1_date", "fp1_time",
                "fp2_date", "fp2_time", "fp3_date", "fp3_time",
                "qualify_date", "qualify_time", "sprint_date",
                "sprint_time"};
    }
}
