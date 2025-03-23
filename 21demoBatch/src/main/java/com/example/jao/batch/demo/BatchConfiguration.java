package com.example.jao.batch.demo;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.jao.batch.demo.listener.JobListener;
import com.example.jao.batch.demo.model.Empleado;
import com.example.jao.batch.demo.processor.EmpleadoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	/*
	 * @Autowired public JobBuilderFactory jobBuilderFactory;
	 * 
	 * @Autowired public StepBuilderFactory stepBuilderFactory;
	 */
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Empleado> reader() {
        return new FlatFileItemReaderBuilder<Empleado>()
                .name("empleadoItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(new String[] {"id", "nombre", "apellidos", "telefono", "dni", "sexo", "profesion"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Empleado>() {{
                    setTargetType(Empleado.class);
                }})
                .build();
    }
    

    @Bean
    public EmpleadoItemProcessor processor() {
        return new EmpleadoItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Empleado> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Empleado>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO empleado (id, nombre, apellidos, telefono, dni, sexo, profesion) VALUES (:id, :nombre, :apellidos, :telefono, :dni, :sexo, :profesion)")
                .dataSource(dataSource)
                .build();
    }

	
    
    
    @Bean
	public Job importEmpleadoJob(JobListener listener, Step step1) {
		return jobBuilderFactory.get("importEmpleadoJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	
	@Bean
	public Step step1(JdbcBatchItemWriter<Empleado> writer) {
		return stepBuilderFactory.get("step1")
				.<Empleado, Empleado> chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer)
				.build();
	}
}
