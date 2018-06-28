package com.spring.university.job.drexel;

import com.spring.SpringSharedConfig;
import com.spring.university.domain.DrexelDomain;
import com.spring.outputFileDomain.HeadersField;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

@Configuration
@EnableBatchProcessing
public class SpringStep {

    private StepBuilderFactory stepBuilderFactory;
    private EntityManagerFactory entityManagerFactory;
    private SpringSharedConfig springSharedConfig;


    @Autowired
    public SpringStep(StepBuilderFactory stepBuilderFactory,
                      EntityManagerFactory entityManagerFactory,
                      SpringSharedConfig springSharedConfig) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.entityManagerFactory = entityManagerFactory;
        this.springSharedConfig = springSharedConfig;
    }

    public JpaPagingItemReader<DrexelDomain> drexelDomainJpaPagingItemReader(){

        JpaPagingItemReader<DrexelDomain> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("select a from DrexelDomain a");
        reader.setPageSize(springSharedConfig.CHUNk_SIZE);
        return reader;
    }
//Todo complete step

    @Bean
    public Step stepRequired(){
        return stepBuilderFactory.get("Job-name")
                .<DrexelDomain, HeadersField> chunk(springSharedConfig.CHUNk_SIZE)
                .reader(drexelDomainJpaPagingItemReader())
                .processor(new Itemprocessor())
                .writer(springSharedConfig.positionWriter())
                .build();
    }
}
