package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DBConfig {

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;
    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;
    @Value("${spring.datasource.url}")
    private String DB_URL;
    @Value("${spring.datasource.driverClassName}")
    private String DB_DRIVER;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username(DB_USERNAME)
                .password(DB_PASSWORD)
                .url(DB_URL)
                .driverClassName(DB_DRIVER)
                .build();
    }
}