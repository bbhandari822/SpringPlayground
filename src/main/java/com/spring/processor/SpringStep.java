package com.spring.processor;

import com.spring.SpringSharedConfig;
import com.spring.domain.FileHeaders;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

@Configuration
@EnableBatchProcessing
public class SpringStep {

    private StepBuilderFactory stepBuilderFactory;
    private JobBuilderFactory jobBuilderFactory;
    private SpringSharedConfig springSharedConfig;


    @Autowired
    public SpringStep(StepBuilderFactory stepBuilderFactory,
                      JobBuilderFactory jobBuilderFactory,
                      SpringSharedConfig springSharedConfig) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
        this.springSharedConfig = springSharedConfig;
    }

//Todo complete step

    @Bean
    public Step stepRequired(){
        return stepBuilderFactory.get("Job-name")
                .<FileHeaders, SpringStep> chunk(1000)
                .build();
    }
}
