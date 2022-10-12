package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.Drivers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class DriversItemProcessor implements ItemProcessor<Drivers, Drivers> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriversItemProcessor.class);

    @Override
    public Drivers process(Drivers drivers) throws Exception {

        var id = drivers.getId();
        var driver_ref = drivers.getDriver_ref();
        var number = drivers.getNumber();
        var code = drivers.getCode();
        var forename = drivers.getForename();
        var surname = drivers.getSurname();
        var dob = drivers.getDob();
        var nationality = drivers.getNationality();
        var url = drivers.getUrl();


        Drivers transformedDrivers = new Drivers(
                id, driver_ref, number, code, forename, surname, dob,
                nationality, url
        );

        LOGGER.info("Converting ( {} ) into ( {} )", drivers, transformedDrivers);

        return transformedDrivers;
    }
}
