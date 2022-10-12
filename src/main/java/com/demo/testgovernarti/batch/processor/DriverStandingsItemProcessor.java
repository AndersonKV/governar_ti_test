package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.ConstructorStandings;
import com.demo.testgovernarti.entities.DriverStandings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class DriverStandingsItemProcessor implements ItemProcessor<DriverStandings, DriverStandings> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverStandingsItemProcessor.class);


    @Override
    public DriverStandings process(DriverStandings driverStandings) throws Exception {

        var id = driverStandings.getId();
        var race_id = driverStandings.getRace_id();
        var driver_id = driverStandings.getDriver_id();
        var points = driverStandings.getPoints();
        var position = driverStandings.getPosition();
        var position_text = driverStandings.getPosition_text();
        var wins = driverStandings.getWins();

        DriverStandings transformedDriverStandings = new DriverStandings(
                id, race_id, driver_id, points, position, position_text, wins
        );

        LOGGER.info("Converting ( {} ) into ( {} )", driverStandings, transformedDriverStandings);

        return transformedDriverStandings;
    }
}
