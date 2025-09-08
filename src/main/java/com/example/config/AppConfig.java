package com.example.config;

import com.example.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example") // scans for @Component beans
public class AppConfig {

    @Bean
    @Scope("singleton")
    public Customer singletonCustomer() {
        Customer customer = new Customer();
        customer.setName("Singleton Customer");
        return customer;
    }

    @Bean
    @Scope("prototype")
    public Customer prototypeCustomer() {
        Customer customer = new Customer();
        customer.setName("Prototype Customer");
        return customer;
    }
}
