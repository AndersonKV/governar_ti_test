package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.LapTimes;
import com.demo.testgovernarti.entities.PitStops;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobPitStopsCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobPitStopsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobPitStopsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobPitStopsCompletion FINISHED! Time to verify the results");


            String query = "SELECT race_id, driver_id, stop, lap, time, duration, milliseconds FROM pits_stop";
            jdbcTemplate.query(query, (rs, row) -> new PitStops(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDouble(7)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}


