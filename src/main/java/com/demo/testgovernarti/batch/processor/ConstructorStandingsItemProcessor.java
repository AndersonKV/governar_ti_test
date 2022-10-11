package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.ConstructorStandings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ConstructorStandingsItemProcessor implements ItemProcessor<ConstructorStandings, ConstructorStandings> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorStandingsItemProcessor.class);


    @Override
    public ConstructorStandings process(ConstructorStandings constructorStandings) throws Exception {

        var id = constructorStandings.getId();
        var raceId = constructorStandings.getRaceId();
        var constructorId = constructorStandings.getConstructorId();
        var points = constructorStandings.getPoints();
        var position = constructorStandings.getPosition();
        var positionText = constructorStandings.getPositionText();
        var wins = constructorStandings.getWins();

        ConstructorStandings transformedCircuit = new ConstructorStandings(
                id, raceId, constructorId, points, position, positionText, wins
        );

        LOGGER.info("Converting ( {} ) into ( {} )", constructorStandings, transformedCircuit);

        return transformedCircuit;
    }
}
