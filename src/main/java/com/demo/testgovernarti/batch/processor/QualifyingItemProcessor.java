package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Qualifying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class QualifyingItemProcessor implements ItemProcessor<Qualifying, Qualifying> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QualifyingItemProcessor.class);

    @Override
    public Qualifying process(Qualifying qualifying) throws Exception {


        var id = qualifying.getId();
        var race_id = qualifying.getRace_id();
        var driver_id = qualifying.getDriver_id();
        var constructor_id = qualifying.getConstructor_id();
        var number = qualifying.getNumber();
        var position = qualifying.getPosition();
        var q1 = qualifying.getQ1();
        var q2 = qualifying.getQ2();
        var q3 = qualifying.getQ3();

        Qualifying transformedQualifying = new Qualifying(
                id, race_id, driver_id, constructor_id, number, position, q1, q2, q3
        );

        LOGGER.info("Converting ( {} ) into ( {} )", qualifying, transformedQualifying);

        return transformedQualifying;
    }
}
