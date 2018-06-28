package com.spring;

import com.spring.university.job.drexel.SpringStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Binod Bhandari on 6/21/18.
 */

@Configuration
public class UniversityJob {

    private JobBuilderFactory jobBuilderFactory;
    private SpringStep springStep;
    private SpringSharedConfig springSharedConfig;


    @Autowired
    public UniversityJob(JobBuilderFactory jobBuilderFactory,
                         SpringStep springStep,
                         SpringSharedConfig springSharedConfig) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.springStep = springStep;
        this.springSharedConfig = springSharedConfig;
    }

    @Bean
    public Job binodJob(){
        return jobBuilderFactory.get("university-job")
                .start(springStep.stepRequired())
                .next(springSharedConfig.sftpStep())
                .build();
    }
}
