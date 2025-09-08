package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default") // This will be used when no profile is active
public class DatabaseConfig {

    @Bean
    public String databaseUrl() {
        System.out.println("*** DEFAULT DATABASE URL BEAN CREATED ***");
        return "jdbc:mysql://localhost:3306/default_db";
    }

    @Bean
    public String databaseUsername() {
        System.out.println("*** DEFAULT DATABASE USERNAME BEAN CREATED ***");
        return "default_user";
    }

    @Bean
    public String databasePassword() {
        System.out.println("*** DEFAULT DATABASE PASSWORD BEAN CREATED ***");
        return "default_password";
    }

    @Bean
    public String environmentName() {
        System.out.println("*** DEFAULT ENVIRONMENT BEAN CREATED ***");
        return "Default Environment (No Profile)";
    }
}
