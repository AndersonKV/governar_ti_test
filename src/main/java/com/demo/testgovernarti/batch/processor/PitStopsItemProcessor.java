package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.PitStops;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PitStopsItemProcessor implements ItemProcessor<PitStops, PitStops> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PitStopsItemProcessor.class);

    @Override
    public PitStops process(PitStops pitStops) throws Exception {

        var race_id = pitStops.getRace_id();
        var driver_id = pitStops.getDriver_id();
        var stop = pitStops.getStop();
        var lap = pitStops.getLap();
        var time = pitStops.getTime();
        var duration = pitStops.getDuration();
        var milliseconds = pitStops.getMilliseconds();

        PitStops transformedPitStops = new PitStops(
                race_id,
                driver_id, stop, lap, time, duration, milliseconds
        );

        LOGGER.info("Converting ( {} ) into ( {} )", pitStops, transformedPitStops);

        return transformedPitStops;
    }
}
