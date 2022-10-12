//package com.demo.testgovernarti.batch.configuration;
//
//import com.demo.testgovernarti.batch.jobCompletionNotification.JobConstructorResultsCompletion;
//import com.demo.testgovernarti.batch.processor.ConstructorResultsItemProcessor;
//import com.demo.testgovernarti.entities.ConstructorResults;
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
//import org.springframework.scheduling.annotation.EnableScheduling;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConstructorResultsConfiguration {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Value("${file.constructor_results}")
//    private String fileInput;
//
//
//    @Bean
//    public FlatFileItemReader<ConstructorResults> reader() {
//        return new FlatFileItemReaderBuilder<ConstructorResults>().name("constructorResultsItemReader")
//                .resource(new ClassPathResource(fileInput))
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
//    public Job jobConstructorResults(JobConstructorResultsCompletion listener, Step step) {
//        return jobBuilderFactory.get("jobConstructorResults")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step stepConstructorResults(JdbcBatchItemWriter<ConstructorResults> writer) {
//        return stepBuilderFactory.get("stepConstructorResults")
//                .<ConstructorResults, ConstructorResults>chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//
//
//}
