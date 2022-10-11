//package com.demo.testgovernarti.config;
//
//import com.demo.testgovernarti.entities.Circuit;
//import com.demo.testgovernarti.services.CircuitRepository;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.core.task.TaskExecutor;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class CircuitBatchConfiguration {
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private CircuitRepository circuitRepository;
//
//
//
//    @Bean
//    public FlatFileItemReader<Circuit> readFromCsv() {
//        FlatFileItemReader<Circuit> reader = new FlatFileItemReader<Circuit>();
//
//        reader.setResource(new FileSystemResource("src/main/resources/assets/circuit.csv"));
//
//        reader.setLineMapper(new DefaultLineMapper<Circuit>() {
//            {
//                setLineTokenizer(new DelimitedLineTokenizer() {
//                    {
//                        setNames(Circuit.fields());
//                    }
//                });
//                setFieldSetMapper(new BeanWrapperFieldSetMapper<Circuit>() {
//                    {
//                        setTargetType(Circuit.class);
//                    }
//                });
//            }
//        });
//        return reader;
//
//    }
//
//    @Bean
//    public RepositoryItemWriter<Circuit> writeIntoDB() {
//       // RepositoryItemWriter<Circuit> writer = new JdbcBatchItemWriter<Circuit>();
//        RepositoryItemWriter<Circuit> writer = new RepositoryItemWriter<>();
//
//        writer.setRepository(circuitRepository);
//        writer.setMethodName("save");
//
//        //writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Circuit>());
//        return writer;
//    }
//
//
//
//    @Bean
//    public Step step() {
//        return stepBuilderFactory.get("step")
//                .<Circuit, Circuit>chunk(10)
//                .reader(readFromCsv())
//                .writer(writeIntoDB())
//                .build();
//    }
//
////    @Bean
////    public Job job() {
////        return jobBuilderFactory.get("job")
////                .flow(step()).end().build();
////
////    }
//
//    @Bean
//    public Job footballJob() {
//        return this.jobBuilderFactory.get("footballJob")
//                .start(playerLoad())
//                .next(gameLoad())
//                .next(playerSummarization())
//                .build();
//    }
//
//
//
//
//
//}
//
