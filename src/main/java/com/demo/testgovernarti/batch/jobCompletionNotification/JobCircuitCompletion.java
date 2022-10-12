package com.demo.testgovernarti.batch.jobCompletionNotification;


import com.demo.testgovernarti.entities.Circuit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCircuitCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobCircuitCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCircuitCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobCircuitCompletion FINISHED! Time to verify the results");

            String query = "SELECT id, circuit_ref, name, location, country, lat, lng, alt, url FROM circuit";
            jdbcTemplate.query(query, (rs, row) -> new Circuit(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6),
                    rs.getDouble(7),
                    rs.getString(8),
                    rs.getString(9)
            ))
                    .forEach(circuit -> LOGGER.info("Found < {} > in the database.", circuit));
        }
    }
}

