package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.PitStops;
import com.demo.testgovernarti.entities.Qualifying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobQualifyingCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobQualifyingCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobQualifyingCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobQualifyingCompletion FINISHED! Time to verify the results");

            String query = "SELECT id, race_id, driver_id, constructor_id, number, position, q1, q2, q3 FROM qualifying";
            jdbcTemplate.query(query, (rs, row) -> new Qualifying(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3),
                    rs.getLong(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}


