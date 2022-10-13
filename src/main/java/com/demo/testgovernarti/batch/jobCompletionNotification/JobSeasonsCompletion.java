package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.Results;
import com.demo.testgovernarti.entities.Seasons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobSeasonsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobSeasonsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobSeasonsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobSeasonsCompletion FINISHED! Time to verify the results");

            String query = "SELECT year, url from seasons";

            jdbcTemplate.query(query, (rs, row) -> new Seasons(
                    rs.getString(1),
                    rs.getString(2)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}

