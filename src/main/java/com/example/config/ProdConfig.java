package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Bean
    public String databaseUrl() {
        System.out.println("*** PROD DATABASE URL BEAN CREATED ***");
        return "jdbc:mysql://prod-server:3306/production_database";
    }

    @Bean
    public String databaseUsername() {
        System.out.println("*** PROD DATABASE USERNAME BEAN CREATED ***");
        return "prod_user";
    }

    @Bean
    public String databasePassword() {
        System.out.println("*** PROD DATABASE PASSWORD BEAN CREATED ***");
        return "super_secure_prod_password";
    }

    @Bean
    public String environmentName() {
        System.out.println("*** PROD ENVIRONMENT BEAN CREATED ***");
        return "Production Environment";
    }
}
