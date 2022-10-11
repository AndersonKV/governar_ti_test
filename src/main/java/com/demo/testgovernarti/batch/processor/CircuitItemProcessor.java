package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Circuit;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class CircuitItemProcessor implements ItemProcessor<Circuit, Circuit> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircuitItemProcessor.class);

    @Override
    public Circuit process(final Circuit circuit) throws Exception {


        var circuitId = circuit.getCircuitId();
        String circuitRef = circuit.getCircuitRef();
        String name = circuit.getName();
        String location = circuit.getLocation();
        String country = circuit.getCountry();
        var lat = circuit.getLat();
        var lng = circuit.getLng();
        var alt = circuit.getAlt();
        String url = circuit.getUrl();

        Circuit transformedCircuit = new Circuit(
                circuitId,
                circuitRef,
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
