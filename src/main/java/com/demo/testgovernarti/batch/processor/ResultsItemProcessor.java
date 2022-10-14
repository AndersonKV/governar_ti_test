package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ResultsItemProcessor implements ItemProcessor<Results, Results> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultsItemProcessor.class);

    @Override
    public Results process(Results results) throws Exception {


        var id = results.getId();
        var race_id = results.getRace_id();
        var driver_id = results.getDriverId();
        var constructor_id = results.getConstructorId();
        var number = results.getNumber();
        var grid = results.getGrid();
        var position = results.getPosition();
        var position_text = results.getPosition_text();
        var position_order = results.getPosition_order();
        var points = results.getPoints();
        var laps = results.getLaps();
        var time = results.getTime();
        var milliseconds = results.getMilliseconds();
        var fastest_lap = results.getFastest_lap();
        var rank = results.getRank();
        var fastest_lap_time = results.getFastest_lap_time();
        var fastest_lap_speed = results.getFastest_lap_speed();
        var status_id = results.getStatus_id();


        Results transformedResultsRaces = new Results(
                id, race_id, driver_id, constructor_id, number,
                grid, position, position_text, position_order, points,
                laps, time, milliseconds, fastest_lap, rank,
                fastest_lap_time, fastest_lap_speed, status_id
        );

        LOGGER.info("Converting ( {} ) into ( {} )", results, transformedResultsRaces);

        return transformedResultsRaces;
    }
}
