package com.example;

import com.example.config.AppConfig;
import com.example.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Customer customer = context.getBean(Customer.class);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Account Number: " + customer.getAccount().getAccountNumber());
    }
}
