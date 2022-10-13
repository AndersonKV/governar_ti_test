package com.demo.testgovernarti.batch.processor;

import com.demo.testgovernarti.entities.Results;
import com.demo.testgovernarti.entities.Seasons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class SeasonsItemProcessor implements ItemProcessor<Seasons, Seasons> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeasonsItemProcessor.class);

    @Override
    public Seasons process(Seasons seasons) throws Exception {
        var year = seasons.getYear();
        var url = seasons.getUrl();

        Seasons transformedSeasons = new Seasons(year, url);

        LOGGER.info("Converting ( {} ) into ( {} )", seasons, transformedSeasons);

        return transformedSeasons;
    }
}
