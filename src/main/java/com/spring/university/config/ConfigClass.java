package com.spring.university.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

@Configuration
public class ConfigClass extends DefaultBatchConfigurer{

    @ConfigurationProperties("spring.config")
    @Bean
    public DataSource dataSource() {
        return (DataSource) new HikariDataSource();
    }
}
