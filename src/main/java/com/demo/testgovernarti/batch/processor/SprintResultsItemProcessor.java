package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Seasons;
import com.demo.testgovernarti.entities.SprintResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class SprintResultsItemProcessor implements ItemProcessor<SprintResults, SprintResults> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SprintResultsItemProcessor.class);

    @Override
    public SprintResults process(SprintResults sprintResults) throws Exception {
        var id = sprintResults.getId();
        var race_id = sprintResults.getRace_id();
        var driver_id = sprintResults.getDriver_id();
        var constructor_id = sprintResults.getConstructor_id();
        var number = sprintResults.getNumber();
        var grid = sprintResults.getGrid();
        var position = sprintResults.getPosition();
        var position_text = sprintResults.getPosition_text();
        var position_order = sprintResults.getPosition_order();
        var points = sprintResults.getPoints();
        var laps = sprintResults.getLaps();
        var time = sprintResults.getTime();
        var milliseconds = sprintResults.getMilliseconds();
        var fastest_lap = sprintResults.getFastest_lap();
        var fastest_lap_time = sprintResults.getFastest_lap_time();
        var status_id = sprintResults.getStatus_id();


        SprintResults transformedSprintResults = new SprintResults(
                id, race_id, driver_id, constructor_id, number, grid,
                position, position_text, position_order, points,
                laps, time, milliseconds, fastest_lap, fastest_lap_time, status_id
        );

        LOGGER.info("Converting ( {} ) into ( {} )", sprintResults, transformedSprintResults);

        return transformedSprintResults;
    }
}

