package com.example.config;

import com.example.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.example") // scans for @Component beans
public class AppConfig {

    @Bean
    @Scope("singleton")
    @Lazy
    public Customer singletonCustomer() {
        System.out.println("*** LAZY SINGLETON BEAN CREATED ***");
        Customer customer = new Customer();
        customer.setName("Lazy Singleton Customer");
        return customer;
    }

    @Bean
    @Scope("prototype")
    public Customer prototypeCustomer() {
        System.out.println("*** PROTOTYPE BEAN CREATED ***");
        Customer customer = new Customer();
        customer.setName("Prototype Customer");
        return customer;
    }
}
