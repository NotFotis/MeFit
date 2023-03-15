package com.example.mefit;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
public class DatabaseProdConfig {
    @Bean
    public DataSource getDataSource() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://mefit-noroff-accelerate.postgres.database.azure.com:5432/");
        dataSourceBuilder.username("Fotis");
        dataSourceBuilder.password("Mefit1998!");
        return dataSourceBuilder.build();
}
}
