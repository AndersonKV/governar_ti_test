package com.demo.testgovernarti.batch.jobCompletionNotification;

import com.demo.testgovernarti.entities.ConstructorResults;
import com.demo.testgovernarti.entities.Constructors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobConstructorsCompletion  extends JobExecutionListenerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobConstructorsCompletion.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobConstructorsCompletion(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("!!! JobConstructorsCompletion FINISHED! Time to verify the results");


            String query = "SELECT id, constructor_ref, name, nationality, url FROM constructors";
            jdbcTemplate.query(query, (rs, row) -> new Constructors(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            ))
                    .forEach(c -> LOGGER.info("Found < {} > in the database.", c));
        }
    }

}