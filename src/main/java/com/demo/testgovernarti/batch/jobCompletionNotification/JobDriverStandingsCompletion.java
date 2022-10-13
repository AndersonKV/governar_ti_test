package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.Constructors;
import com.demo.testgovernarti.entities.DriverStandings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JobDriverStandingsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobDriverStandingsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobDriverStandingsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobDriverStandingsCompletion FINISHED! Time to verify the results");


            String query = "SELECT id, driver_ref, number, code, forename, surname, dob, nationality, url FROM drivers";
            jdbcTemplate.query(query, (rs, row) -> new DriverStandings(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3),
                    rs.getDouble(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getInt(7)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}
