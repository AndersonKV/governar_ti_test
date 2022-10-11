package com.demo.testgovernarti.batch.configuration;

import com.demo.testgovernarti.batch.jobCompletionNotification.JobCircuitCompletion;
import com.demo.testgovernarti.batch.processor.CircuitItemProcessor;
import com.demo.testgovernarti.entities.Circuit;
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
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

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



//    @Bean
//    public FlatFileItemReader<Circuit> reader() {
//        FlatFileItemReader<Circuit> reader = new FlatFileItemReader<Circuit>();
//
//        reader.setResource(new ClassPathResource(fileInput));
//        reader.setLineMapper(new DefaultLineMapper<Circuit>() {
//            {
//                setLineTokenizer(new DelimitedLineTokenizer() {
//                    {
//                        setNames(Circuit.fields());
//                    }
//                });
//                {
//                    setFieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {
//                        {
//                            setTargetType(Circuit.class);
//                        }
//                    });
//                }
//            }
//        });
//
//        return reader;
//        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
//                .resource(new ClassPathResource(fileInput))
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {
//                    {
//                        setTargetType(Circuit.class);
//                    }
//                })

   // }

//    @Bean
//    public FlatFileItemReader<Circuit> reader() {
//        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
//                .resource(new ClassPathResource(fileInput))
//                .delimited()
//                .names(new String[]{
//                        "circuitId",
//                        "circuitRef",
//                        "name",
//                        "location",
//                        "country",
//                        "lat",
//                        "lng",
//                        "alt",
//                        "url"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {{
//                    setTargetType(Circuit.class);
//                }})
//                .build();
//    }

    @Bean
    public FlatFileItemReader<Circuit> reader() {
        return new FlatFileItemReaderBuilder<Circuit>().name("circuitItemReader")
                .resource(new ClassPathResource(fileInput))
                .delimited()
                .names(new String[]{
                        "circuitId",
                        "circuitRef",
                        "name",
                        "location",
                        "country",
                        "lat",
                        "lng",
                        "alt",
                        "url"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {{
                    setTargetType(Circuit.class);
                }})
                .build();

}
    @Bean
    public CircuitItemProcessor processor() {
        return new CircuitItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Circuit> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Circuit>().itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO circuit (circuitId, circuitRef, name,location, country, lat, lng, alt, url) VALUES " +
                        "(:circuitId, :circuitRef, :name,:location, :country, :lat, :lng, :alt, :url)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCircuitCompletion listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Circuit> writer) {
        return stepBuilderFactory.get("step1")
                .<Circuit, Circuit>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
