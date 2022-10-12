package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.DriverStandings;
import com.demo.testgovernarti.entities.LapTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobLapTimesCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobLapTimesCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobLapTimesCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobLapTimesCompletion FINISHED! Time to verify the results");


            String query = "SELECT race_id, driver_id, lap, position, time, milliseconds FROM lap_times";
            jdbcTemplate.query(query, (rs, row) -> new LapTimes(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}

