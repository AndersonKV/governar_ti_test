package com.demo.testgovernarti.batch.configuration;

import com.demo.testgovernarti.batch.jobCompletionNotification.JobDriverStandingsCompletion;
import com.demo.testgovernarti.batch.processor.DriverStandingsItemProcessor;
import com.demo.testgovernarti.entities.DriverStandings;
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

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${file.circuits}")
    private String fileInputCircuits;

    @Value("${file.constructor_results}")
    private String fileInputConstructorResults;

    @Value("${file.constructor_standings}")
    private String fileInputConstructorStandings;

    @Value("${file.constructors}")
    private String fileInputConstructors;

    @Value("${file.driver_standings}")
    private String fileInputDriverStandings;


    /**************************************************

     INICIO CIRCUIT
     **************************************************
     */
//
//    @Bean
//    public FlatFileItemReader<Circuit> circuitReader() {
//        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
//                .resource(new ClassPathResource(fileInputCircuits))
//                .delimited()
//                .names("id",
//                        "circuit_ref",
//                        "name",
//                        "location",
//                        "country",
//                        "lat",
//                        "lng",
//                        "alt",
//                        "url")
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {{
//                    setTargetType(Circuit.class);
//                }})
//                .build();
//
//    }
//
//    @Bean
//    public CircuitItemProcessor processorCircuit() { return new CircuitItemProcessor(); };
//
//    @Bean
//    public JdbcBatchItemWriter<Circuit> circuitWriter(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Circuit>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO circuit (id, circuit_ref, name,location, country, lat, lng, alt, url) VALUES " +
//                        "(:id, :circuit_ref, :name,:location, :country, :lat, :lng, :alt, :url)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Step step1(JdbcBatchItemWriter<Circuit> writer) {
//        return stepBuilderFactory.get("step1")
//                .<Circuit, Circuit>chunk(10)
//                .reader(circuitReader())
//                .processor(processorCircuit())
//                .writer(writer)
//                .build();
//    }
//
//
//
//
//    @Bean
//    public Job job1(JobCircuitCompletion listener, Step step1) {
//        return jobBuilderFactory.get("job1")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }

    /**************************************************

     INICIO CONSTRUCTOR_RESULTS
     **************************************************
     */

//    @Bean
//    public FlatFileItemReader<ConstructorResults> reader() {
//        return new FlatFileItemReaderBuilder<ConstructorResults>().name("constructorResultsItemReader")
//                .resource(new ClassPathResource(fileInputConstructorResults))
//                .delimited()
//                .names("id",
//                        "race_id",
//                        "constructor_id",
//                        "points",
//                        "status")
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorResults>() {{
//                    setTargetType(ConstructorResults.class);
//                }})
//                .build();
//
//    }
//
//    @Bean
//    public ConstructorResultsItemProcessor processor() {
//        return new ConstructorResultsItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<ConstructorResults> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<ConstructorResults>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO constructor_results (id, race_id, constructor_id, points,status) VALUES " +
//                        "(:id, :race_id, :constructor_id,:points, :status)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Job job2(JobConstructorResultsCompletion listener, Step step2) {
//        return jobBuilderFactory.get("job2")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step2)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step2(JdbcBatchItemWriter<ConstructorResults> writer) {
//        return stepBuilderFactory.get("step2")
//                .<ConstructorResults, ConstructorResults>chunk(12000)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//    @Bean
//    public ThreadPoolTaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        taskExecutor.setMaxPoolSize(threadPoolSize);
//        taskExecutor.setCorePoolSize(threadCorePoolSize);
//        taskExecutor.setQueueCapacity(threadQueuePoolSize);
//        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        taskExecutor.afterPropertiesSet();
//        return taskExecutor;
//    }

/**************************************************

 INICIO CONSTRUCTOR_STANDINGS
 **************************************************
 */

//
//    @Bean
//    public FlatFileItemReader<ConstructorStandings> constructorStandingsReader() {
//        return new FlatFileItemReaderBuilder<ConstructorStandings>().name("constructorStandingsReader")
//                .resource(new ClassPathResource(fileInputConstructorStandings))
//                .delimited()
//                .names("id",
//                        "race_id",
//                        "constructor_id",
//                        "points",
//                        "position",
//                        "position_text",
//                        "wins")
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorStandings>() {{
//                    setTargetType(ConstructorStandings.class);
//                }})
//                .build();
//    }
//
//
//
//    @Bean
//    public ConstructorStandingsItemProcessor processorConstructorStandings() {
//        return new ConstructorStandingsItemProcessor();
//    }
//
//
//    @Bean
//    public JdbcBatchItemWriter<ConstructorStandings> constructorStandingsWriter(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<ConstructorStandings>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO constructor_standings (id, race_id, constructor_id, points,position, position_text, wins) VALUES " +
//                        "(:id, :race_id, :constructor_id,:points, :position, :position_text, :wins)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Step step3(JdbcBatchItemWriter<ConstructorStandings> writer) {
//        return stepBuilderFactory.get("step3")
//                .<ConstructorStandings, ConstructorStandings>chunk(130)
//                .reader(constructorStandingsReader())
//                .processor(processorConstructorStandings())
//                .writer(writer)
//                .build();
//    }
//
//
//    @Bean
//    public Job job3(JobConstructorStandingsCompletion listener, Step step3) {
//        return jobBuilderFactory.get("job3")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step3)
//                .end()
//                .build();
//    }
//


    /**************************************************

     INICIO CONSTRUCTORS
     **************************************************
     */


//    @Bean
//    public FlatFileItemReader<Constructors> constructorsItemReader() {
//        return new FlatFileItemReaderBuilder<Constructors>().name("constructorsItemReader")
//                .resource(new ClassPathResource(fileInputConstructors))
//                .delimited()
//                .names("id",
//                        "constructor_ref",
//                        "name",
//                        "nationality",
//                        "url")
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Constructors>() {{
//                    setTargetType(Constructors.class);
//                }})
//                .build();
//    }
//
//
//
//    @Bean
//    public ConstructorsItemProcessor constructorsItemProcessor() {
//        return new ConstructorsItemProcessor();
//    }
//
//
//    @Bean
//    public JdbcBatchItemWriter<Constructors> constructorsItemWriter(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Constructors>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO constructors (id, constructor_ref, name, nationality,url) VALUES " +
//                        "(:id, :constructor_ref, :name, :nationality, :url)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Step step4(JdbcBatchItemWriter<Constructors> writer) {
//        return stepBuilderFactory.get("step4")
//                .<Constructors, Constructors>chunk(250)
//                .reader(constructorsItemReader())
//                .processor(constructorsItemProcessor())
//                .writer(writer)
//                .build();
//    }
//
//
//    @Bean
//    public Job job4(JobConstructorStandingsCompletion listener, Step step4) {
//        return jobBuilderFactory.get("job4")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step4)
//                .end()
//                .build();
//    }


    /**************************************************

     INICIO DRIVER_CONSTRUCTORS
     **************************************************
     */


    @Bean
    public FlatFileItemReader<DriverStandings> driverStandingsItemReader() {
        return new FlatFileItemReaderBuilder<DriverStandings>().name("driverStandingsItemReader")
                .resource(new ClassPathResource(fileInputDriverStandings))
                .delimited()
                .names("id",
                        "race_id",
                        "driver_id",
                        "points",
                        "position",
                        "position_text",
                        "wins"
                        )
                .fieldSetMapper(new BeanWrapperFieldSetMapper<DriverStandings>() {{
                    setTargetType(DriverStandings.class);
                }})
                .build();
    }


    @Bean
    public DriverStandingsItemProcessor driverStandingsItemProcessor() {
        return new DriverStandingsItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<DriverStandings> driverStandingsItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<DriverStandings>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO driver_standings (id, race_id, driver_id, points,position, position_text, wins) VALUES " +
                        "(:id, :race_id, :driver_id, :points, :position,:position_text, :wins)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step5(JdbcBatchItemWriter<DriverStandings> writer) {
        return stepBuilderFactory.get("step5")
                .<DriverStandings, DriverStandings>chunk(350)
                .reader(driverStandingsItemReader())
                .processor(driverStandingsItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job5(JobDriverStandingsCompletion listener, Step step5) {
        return jobBuilderFactory.get("job5")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step5)
                .end()
                .build();
    }

}
