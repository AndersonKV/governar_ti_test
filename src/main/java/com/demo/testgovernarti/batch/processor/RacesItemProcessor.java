package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Races;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class RacesItemProcessor implements ItemProcessor<Races, Races> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RacesItemProcessor.class);

    @Override
    public Races process(Races races) throws Exception {


        var id = races.getId();
        var year = races.getYears();
        var round = races.getRound();
        var circuit_id = races.getCircuitId();
        var name = races.getName();
        var date = races.getDate();
        var time = races.getTime();
        var url = races.getUrl();
        var fp1_date = races.getFp1Date();
        var fp1_time = races.getFp1Time();
        var fp2_date = races.getFp2Date();
        var fp2_time = races.getFp2Time();
        var fp3_date = races.getFp3Date();
        var fp3_time = races.getFp3Time();
        var qualify_date = races.getQualifyDate();
        var qualify_time = races.getQualifyTime();
        var sprint_date = races.getSprintDate();
        var sprint_time = races.getSprintTime();

        Races transformedRaces = new Races(id,
                year,
                round,
                circuit_id, name, date, time, url, fp1_date,
                fp1_time, fp2_date, fp2_time, fp3_date, fp3_time,
                qualify_date, qualify_time, sprint_date, sprint_time
        );

        LOGGER.info("Converting ( {} ) into ( {} )", races, transformedRaces);

        return transformedRaces;
    }
}
