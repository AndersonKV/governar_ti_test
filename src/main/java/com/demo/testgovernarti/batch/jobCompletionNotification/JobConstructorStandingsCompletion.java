package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.ConstructorResults;
import com.demo.testgovernarti.entities.ConstructorStandings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobConstructorStandingsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobConstructorStandingsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobConstructorStandingsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JOB FINISHED! Time to verify the results");

            String query = "SELECT id, raceId, constructorId, points, position, positionText, wins FROM constructor_standings";
            jdbcTemplate.query(query, (rs, row) -> new ConstructorStandings(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getInt(7)
            ))
                    .forEach(constructorStandings -> LOGGER.info("Found < {} > in the database.", constructorStandings));
        }
    }
}

