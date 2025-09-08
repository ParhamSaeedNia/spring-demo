package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public String databaseUrl() {
        System.out.println("*** DEV DATABASE URL BEAN CREATED ***");
        return "jdbc:mysql://localhost:3306/dev_database";
    }

    @Bean
    public String databaseUsername() {
        System.out.println("*** DEV DATABASE USERNAME BEAN CREATED ***");
        return "dev_user";
    }

    @Bean
    public String databasePassword() {
        System.out.println("*** DEV DATABASE PASSWORD BEAN CREATED ***");
        return "dev_password";
    }

    @Bean
    public String environmentName() {
        System.out.println("*** DEV ENVIRONMENT BEAN CREATED ***");
        return "Development Environment";
    }
}
