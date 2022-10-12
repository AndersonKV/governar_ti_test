package com.demo.testgovernarti.batch.configuration;

import com.demo.testgovernarti.batch.jobCompletionNotification.*;
import com.demo.testgovernarti.batch.processor.*;
import com.demo.testgovernarti.entities.*;
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

    @Value("${file.drivers}")
    private String fileInputDrivers;

    @Value("${file.lap_times}")
    private String fileInputLapTimes;


    /**************************************************
     INICIO CIRCUIT
     **************************************************
     */

    @Bean
    public FlatFileItemReader<Circuit> circuitItemReader() {
        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
                .resource(new ClassPathResource(fileInputCircuits))
                .delimited()
                .names("id",
                        "circuit_ref",
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
    public CircuitItemProcessor circuitItemProcessor() {
        return new CircuitItemProcessor();
    }

    ;

    @Bean
    public JdbcBatchItemWriter<Circuit> circuitItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Circuit>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO circuit (id, circuit_ref, name,location, country, lat, lng, alt, url) VALUES " +
                        "(:id, :circuit_ref, :name,:location, :country, :lat, :lng, :alt, :url)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Circuit> writer) {
        return stepBuilderFactory.get("step1")
                .<Circuit, Circuit>chunk(10)
                .reader(circuitItemReader())
                .processor(circuitItemProcessor())
                .writer(writer)
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

    /**************************************************
     INICIO CONSTRUCTOR_RESULTS
     **************************************************
     */

    @Bean
    public FlatFileItemReader<ConstructorResults> constructorResultsItemReader() {
        return new FlatFileItemReaderBuilder<ConstructorResults>().name("constructorResultsItemReader")
                .resource(new ClassPathResource(fileInputConstructorResults))
                .delimited()
                .names("id",
                        "race_id",
                        "constructor_id",
                        "points",
                        "status")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorResults>() {{
                    setTargetType(ConstructorResults.class);
                }})
                .build();

    }

    @Bean
    public ConstructorResultsItemProcessor constructorResultsItemProcessor() {
        return new ConstructorResultsItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<ConstructorResults> constructorResultsItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<ConstructorResults>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO constructor_results (id, race_id, constructor_id, points,status) VALUES " +
                        "(:id, :race_id, :constructor_id,:points, :status)")
                .dataSource(dataSource)
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
                .<ConstructorResults, ConstructorResults>chunk(12000)
                .reader(constructorResultsItemReader())
                .processor(constructorResultsItemProcessor())
                .writer(writer)
                .build();
    }


    /**************************************************
     INICIO CONSTRUCTOR_STANDINGS
     **************************************************
     */


    @Bean
    public FlatFileItemReader<ConstructorStandings> constructorStandingsReader() {
        return new FlatFileItemReaderBuilder<ConstructorStandings>().name("constructorStandingsReader")
                .resource(new ClassPathResource(fileInputConstructorStandings))
                .delimited()
                .names("id",
                        "race_id",
                        "constructor_id",
                        "points",
                        "position",
                        "position_text",
                        "wins")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ConstructorStandings>() {{
                    setTargetType(ConstructorStandings.class);
                }})
                .build();
    }


    @Bean
    public ConstructorStandingsItemProcessor constructorStandingsItemProcessor() {
        return new ConstructorStandingsItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<ConstructorStandings> constructorStandingsWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<ConstructorStandings>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO constructor_standings (id, race_id, constructor_id, points,position, position_text, wins) VALUES " +
                        "(:id, :race_id, :constructor_id,:points, :position, :position_text, :wins)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step3(JdbcBatchItemWriter<ConstructorStandings> writer) {
        return stepBuilderFactory.get("step3")
                .<ConstructorStandings, ConstructorStandings>chunk(300)
                .reader(constructorStandingsReader())
                .processor(constructorStandingsItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job3(JobConstructorStandingsCompletion listener, Step step3) {
        return jobBuilderFactory.get("job3")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step3)
                .end()
                .build();
    }


    /**************************************************
     INICIO CONSTRUCTORS
     **************************************************
     */


    @Bean
    public FlatFileItemReader<Constructors> constructorsItemReader() {
        return new FlatFileItemReaderBuilder<Constructors>().name("constructorsItemReader")
                .resource(new ClassPathResource(fileInputConstructors))
                .delimited()
                .names("id",
                        "constructor_ref",
                        "name",
                        "nationality",
                        "url")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Constructors>() {{
                    setTargetType(Constructors.class);
                }})
                .build();
    }


    @Bean
    public ConstructorsItemProcessor constructorsItemProcessor() {
        return new ConstructorsItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<Constructors> constructorsItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Constructors>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO constructors (id, constructor_ref, name, nationality,url) VALUES " +
                        "(:id, :constructor_ref, :name, :nationality, :url)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step4(JdbcBatchItemWriter<Constructors> writer) {
        return stepBuilderFactory.get("step4")
                .<Constructors, Constructors>chunk(250)
                .reader(constructorsItemReader())
                .processor(constructorsItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job4(JobConstructorStandingsCompletion listener, Step step4) {
        return jobBuilderFactory.get("job4")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step4)
                .end()
                .build();
    }


    /**************************************************
     INICIO DRIVER_STANDINGS
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
                        "wins")
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
                .sql("INSERT INTO driver_standings (id, race_id, driver_id, points,position, wins) VALUES " +
                        "(:id, :race_id, :driver_id, :points, :position, :wins)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step5(JdbcBatchItemWriter<DriverStandings> writer) {
        return stepBuilderFactory.get("step5")
                .<DriverStandings, DriverStandings>chunk(250)
                .reader(driverStandingsItemReader())
                .processor(driverStandingsItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job5(JobConstructorStandingsCompletion listener, Step step5) {
        return jobBuilderFactory.get("job5")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step5)
                .end()
                .build();
    }


    /**************************************************

     INICIO DRIVERS
     **************************************************
     */


    @Bean
    public FlatFileItemReader<Drivers> driversItemReader() {
        return new FlatFileItemReaderBuilder<Drivers>().name("driversItemReader")
                .resource(new ClassPathResource(fileInputDrivers))
                .delimited()
                .names("id", "driver_ref", "number",
                        "code", "forename", "surname", "dob",
                        "nationality", "url")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Drivers>() {{
                    setTargetType(Drivers.class);
                }})
                .build();
    }


    @Bean
    public DriversItemProcessor driversItemProcessor() {
        return new DriversItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<Drivers> driversItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Drivers>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO drivers (id, driver_ref, number, code, forename, surname, dob, nationality, url ) VALUES " +
                        "(:id, :driver_ref, :number, :code, :forename, :surname, :dob, :nationality, :url )")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step6(JdbcBatchItemWriter<Drivers> writer) {
        return stepBuilderFactory.get("step6")
                .<Drivers, Drivers>chunk(10)
                .reader(driversItemReader())
                .processor(driversItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job6(JobDriverStandingsCompletion listener, Step step6) {
        return jobBuilderFactory.get("job6")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step6)
                .end()
                .build();
    }

    /**************************************************

     INICIO LAP_TIMES
     **************************************************
     */


    @Bean
    public FlatFileItemReader<LapTimes> lapTimesItemReader() {
        return new FlatFileItemReaderBuilder<LapTimes>().name("lapTimesItemReader")
                .resource(new ClassPathResource(fileInputLapTimes))
                .delimited()
                .names("race_id",
                        "driver_id",
                        "lap",
                        "position",
                        "time",
                        "milliseconds")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<LapTimes>() {{
                    setTargetType(LapTimes.class);
                }})
                .build();
    }


    @Bean
    public LapTimesItemProcessor lapTimesItemProcessor() {
        return new LapTimesItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<LapTimes> lapTimesItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<LapTimes>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO lap_times (race_id, driver_id, lap, position, time, milliseconds) VALUES " +
                        "(:race_id, :driver_id, :lap, :position, :time, :milliseconds )")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step7(JdbcBatchItemWriter<LapTimes> writer) {
        return stepBuilderFactory.get("step7")
                .<LapTimes, LapTimes>chunk(5000)
                .reader(lapTimesItemReader())
                .processor(lapTimesItemProcessor())
                .writer(writer)
                .build();
    }


    @Bean
    public Job job7(JobLapTimesCompletion listener, Step step7) {
        return jobBuilderFactory.get("job7")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step7)
                .end()
                .build();
    }

    /**************************************************

     INICIO PIT STOP
     **************************************************
     */

}