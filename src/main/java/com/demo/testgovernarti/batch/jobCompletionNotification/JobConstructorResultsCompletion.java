package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.ConstructorResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobConstructorResultsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobConstructorResultsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobConstructorResultsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JOB FINISHED! Time to verify the results");

            String query = "SELECT id, raceId, constructorId, points, status FROM constructorresults";
            jdbcTemplate.query(query, (rs, row) -> new ConstructorResults(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3),
                    rs.getDouble(4),
                    rs.getString(5)
            ))
                    .forEach(constructorResults -> LOGGER.info("Found < {} > in the database.", constructorResults));
        }
    }
}