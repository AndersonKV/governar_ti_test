package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StatusItemProcessor implements ItemProcessor<Status, Status> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusItemProcessor.class);

    @Override
    public Status process(Status status) throws Exception {
        var id = status.getId();
        var stats = status.getStatus();


        Status transformedStatus = new Status(
                id, stats
        );

        LOGGER.info("Converting ( {} ) into ( {} )", status, transformedStatus);

        return transformedStatus;
    }
}


