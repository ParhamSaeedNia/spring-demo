package com.example.config;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Customer customer() {
        return new Customer("Parham");
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }
}
