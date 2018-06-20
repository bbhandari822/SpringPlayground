package com.spring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.activation.DataSource;
import java.sql.SQLException;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

@Configuration
public class ConfigClass extends HikariConfig{

    @Bean
    public DataSource dataSource() throws SQLException {
        return (DataSource) new HikariDataSource();
    }
}
