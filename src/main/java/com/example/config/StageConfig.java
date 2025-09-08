package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("stage")
public class StageConfig {

    @Bean
    public String databaseUrl() {
        System.out.println("*** STAGE DATABASE URL BEAN CREATED ***");
        return "jdbc:mysql://stage-server:3306/staging_database";
    }

    @Bean
    public String databaseUsername() {
        System.out.println("*** STAGE DATABASE USERNAME BEAN CREATED ***");
        return "stage_user";
    }

    @Bean
    public String databasePassword() {
        System.out.println("*** STAGE DATABASE PASSWORD BEAN CREATED ***");
        return "stage_password";
    }

    @Bean
    public String environmentName() {
        System.out.println("*** STAGE ENVIRONMENT BEAN CREATED ***");
        return "Staging Environment";
    }
}
