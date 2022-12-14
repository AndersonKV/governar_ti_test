package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.Seasons;
import com.demo.testgovernarti.entities.SprintResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobSprintResultsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobSprintResultsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobSprintResultsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobSprintResultsCompletion FINISHED! Time to verify the results");

            String query = "SELECT id, race_id, driver_id," +
                    "constructor_id, number,grid, position,position_text," +
                    "position_order, points, laps,time, milliseconds,fastest_lap," +
                    "fastest_lap_time,status_id  from sprint_results";

            jdbcTemplate.query(query, (rs, row) -> new SprintResults(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3),
                    rs.getLong(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}


