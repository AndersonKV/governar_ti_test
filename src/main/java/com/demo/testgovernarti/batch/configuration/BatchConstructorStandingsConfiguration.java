//package com.demo.testgovernarti.batch.configuration;
//
//import com.demo.testgovernarti.batch.jobCompletionNotification.JobConstructorStandingsCompletion;
//import com.demo.testgovernarti.batch.processor.ConstructorStandingsItemProcessor;
//import com.demo.testgovernarti.entities.ConstructorStandings;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConstructorStandingsConfiguration {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Value("${file.constructor_standings}")
//    private String fileInputConstructorStandings;
//
//
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
//    public Step stepConstructorStandings(JdbcBatchItemWriter<ConstructorStandings> writer) {
//        return stepBuilderFactory.get("stepConstructorStandings")
//                .<ConstructorStandings, ConstructorStandings>chunk(10)
//                .reader(constructorStandingsReader())
//                .processor(processorConstructorStandings())
//                .writer(writer)
//                .build();
//    }
//
//
//    @Bean
//    public Job jobConstructorStandings(JobConstructorStandingsCompletion listener, Step step) {
//        return jobBuilderFactory.get("jobConstructorStandings")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step)
//                .end()
//                .build();
//    }
//
//
//}
