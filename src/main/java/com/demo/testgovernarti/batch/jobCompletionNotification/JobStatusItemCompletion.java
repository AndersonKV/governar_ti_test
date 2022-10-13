package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.SprintResults;
import com.demo.testgovernarti.entities.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobStatusItemCompletion extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobStatusItemCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobStatusItemCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobStatusItemCompletion FINISHED! Time to verify the results");

            String query = "SELECT id, status from status";

            jdbcTemplate.query(query, (rs, row) -> new Status(
                    rs.getLong(1),
                    rs.getString(2)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}


