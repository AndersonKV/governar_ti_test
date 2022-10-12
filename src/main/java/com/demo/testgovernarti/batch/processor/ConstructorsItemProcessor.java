package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Circuit;
import com.demo.testgovernarti.entities.Constructors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class ConstructorsItemProcessor implements ItemProcessor<Constructors, Constructors> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorsItemProcessor.class);

    @Override
    public Constructors process(final Constructors constructors) throws Exception {


        var id = constructors.getId();
        var circuit_ref = constructors.getConstructor_ref();
        var name = constructors.getName();
        var nationality = constructors.getNationality();
        var url = constructors.getUrl();


        Constructors transformedConstructors = new Constructors(
                id, circuit_ref, name, nationality, url
        );
        LOGGER.info("Converting ( {} ) into ( {} )", constructors, transformedConstructors);

        return transformedConstructors;
    }


}
