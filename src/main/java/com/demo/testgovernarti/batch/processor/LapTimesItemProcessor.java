package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.LapTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class LapTimesItemProcessor implements ItemProcessor<LapTimes, LapTimes> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LapTimesItemProcessor.class);


    private Long id;
    private Long driver_id;
    private String lap;
    private String position;
    private Double time;
    private Integer milliseconds;


    @Override
    public LapTimes process(LapTimes driverStandings) throws Exception {

         var race_id = driverStandings.getRace_id();
        var driver_id = driverStandings.getDriver_id();
        var lap = driverStandings.getLap();
        var position = driverStandings.getPosition();
        var time = driverStandings.getTime();
        var milliseconds = driverStandings.getMilliseconds();

        LapTimes transformedLapTimes = new LapTimes(
                race_id, driver_id, lap
                , position, time, milliseconds
        );

        LOGGER.info("Converting ( {} ) into ( {} )", driverStandings, transformedLapTimes);

        return transformedLapTimes;
    }
}
