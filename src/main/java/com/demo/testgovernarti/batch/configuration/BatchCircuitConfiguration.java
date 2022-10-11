package com.demo.testgovernarti.batch.configuration;

import com.demo.testgovernarti.batch.jobCompletionNotification.JobCircuitCompletion;
import com.demo.testgovernarti.batch.jobCompletionNotification.JobConstructorResultsCompletion;
import com.demo.testgovernarti.batch.processor.CircuitItemProcessor;
import com.demo.testgovernarti.batch.processor.ConstructorResultsItemProcessor;
import com.demo.testgovernarti.entities.Circuit;
import com.demo.testgovernarti.entities.ConstructorResults;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchCircuitConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${file.circuits}")
    private String fileInput;

    @Value("${file.constructorResultsId}")
    private String fileInputContructor;

    private Integer threadPoolSize = 20;

    private Integer threadCorePoolSize = 5;

    private Integer threadQueuePoolSize = 5;

    private Integer chunkSize = 2;

    @Bean
    public FlatFileItemReader<Circuit> circuitReader() {
        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .names("id",
                        "circuitRef",
                        "name",
                        "location",
                        "country",
                        "lat",
                        "lng",
                        "alt",
                        "url")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {{
                    setTargetType(Circuit.class);
                }})
                .build();

    }

    @Bean
    public FlatFileItemReader<ConstructorResults> constructorResultsReader() {
        return new FlatFileItemReaderBuilder<ConstructorResults>().name("constructorResultsItemReader")
                .resource(new ClassPathResource(fileInputContructor))
                .delimited()
                .names(new String[]{
                        "id",
                        "raceId",
                        "constructorId",
                        "points",
                        "status"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorResults>() {{
                    setTargetType(ConstructorResults.class);
                }})
                .build();

    }


    @Bean
    public CircuitItemProcessor processorCircuit() {
        return new CircuitItemProcessor();
    }

    @Bean
    public ConstructorResultsItemProcessor processorConstructorResults() {
        return new ConstructorResultsItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<Circuit> circuitWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Circuit>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO circuit (id, circuitRef, name,location, country, lat, lng, alt, url) VALUES " +
                        "(:id, :circuitRef, :name,:location, :country, :lat, :lng, :alt, :url)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<ConstructorResults> constructorWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<ConstructorResults>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO constructorresults (id, raceId, constructorId, points,status) VALUES " +
                        "(:id, :raceId, :constructorId,:points, :status)")
                .dataSource(dataSource)
                .build();
    }






    @Bean
    public Job job1(JobCircuitCompletion listener, Step step1) {
        return jobBuilderFactory.get("job1")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Circuit> writer) {
        return stepBuilderFactory.get("1")
                .<Circuit, Circuit>chunk(10)
                .reader(circuitReader())
                .processor(processorCircuit())
                .writer(writer)
                .build();
    }



    @Bean
    public Job job2(JobConstructorResultsCompletion listener, Step step2) {
        return jobBuilderFactory.get("job2")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step2)
                .end()
                .build();
    }


    @Bean
    public Step step2(JdbcBatchItemWriter<ConstructorResults> writer) {
        return stepBuilderFactory.get("step2")
                .<ConstructorResults, ConstructorResults>chunk(10)
                .reader(constructorResultsReader())
                .processor(processorConstructorResults())
                .writer(writer)
                .build();
    }


    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(threadPoolSize);
        taskExecutor.setCorePoolSize(threadCorePoolSize);
        taskExecutor.setQueueCapacity(threadQueuePoolSize);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }
}
