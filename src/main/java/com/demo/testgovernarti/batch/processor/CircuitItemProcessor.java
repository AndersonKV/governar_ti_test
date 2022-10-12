package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Circuit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class CircuitItemProcessor implements ItemProcessor<Circuit, Circuit> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitItemProcessor.class);

    @Override
    public Circuit process(final Circuit circuit) throws Exception {


        var id = circuit.getId();
        var circuit_ref = circuit.getCircuit_ref();
        var name = circuit.getName();
        var location = circuit.getLocation();
        var country = circuit.getCountry();
        var lat = circuit.getLat();
        var lng = circuit.getLng();
        var url = circuit.getUrl();
        var alt = circuit.getAlt();

        Circuit transformedCircuit = new Circuit(
                id,
                circuit_ref,
                name,
                location,
                country,
                lat,
                lng,
                alt,
                url);
        LOGGER.info("Converting ( {} ) into ( {} )", circuit, transformedCircuit);

        return transformedCircuit;
    }

}
