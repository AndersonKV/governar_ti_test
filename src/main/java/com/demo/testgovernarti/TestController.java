package com.demo.testgovernarti;

import com.demo.testgovernarti.entities.Circuit;
import com.demo.testgovernarti.entities.ConstructorResults;
import com.demo.testgovernarti.repository.ConstructorResultsRepository;
import com.demo.testgovernarti.repository.ConstructorStandingsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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


//    @GetMapping(value = "/q")
//    public String test2() {
//        String str = Arrays.toString(Circuit.fields());
//
//        return  str;
//    }
//
//
//    @GetMapping(value = "/a")
//    public String[] test3() {
//        return Circuit.insertFields();
//    }
}
