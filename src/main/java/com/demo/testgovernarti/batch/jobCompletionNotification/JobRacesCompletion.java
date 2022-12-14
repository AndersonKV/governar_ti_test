package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.Qualifying;
import com.demo.testgovernarti.entities.Races;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobRacesCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobRacesCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobRacesCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobRacesCompletion FINISHED! Time to verify the results");

            String query = "SELECT id, years, round, circuitId, name, date, time, url, " +
                    "fp1Date, fp1Time, fp2Date, fp2Time, " +
                    "fp3Date, fp3Time, qualifyDate, qualifyTime, sprintDate, " +
                    "sprintTime FROM races";

            jdbcTemplate.query(query, (rs, row) -> new Races(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getLong(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getString(15),
                    rs.getString(16),
                    rs.getString(17),
                    rs.getString(18),
                    rs.getString(19)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}

