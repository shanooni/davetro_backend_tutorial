package io.shanoon.quickstarter.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource source){
        return new JdbcTemplate(source);
    }
}
