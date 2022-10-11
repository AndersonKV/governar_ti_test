package com.demo.testgovernarti.batch.processor;

  import com.demo.testgovernarti.entities.ConstructorResults;
  import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ConstructorResultsItemProcessor implements ItemProcessor<ConstructorResults, ConstructorResults> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorResultsItemProcessor.class);


    @Override
    public ConstructorResults process(ConstructorResults constructorResultsId) throws Exception {

        var id = constructorResultsId.getId();
        var raceId = constructorResultsId.getRaceId();
        var constructorId = constructorResultsId.getConstructorId();
        var points = constructorResultsId.getPoints();
        var status = constructorResultsId.getStatus();

        ConstructorResults transformedCircuit = new ConstructorResults(
                id,
                raceId,
                constructorId,
                points,
                status
        );

        LOGGER.info("Converting ( {} ) into ( {} )", constructorResultsId, transformedCircuit);

        return transformedCircuit;
    }
}
