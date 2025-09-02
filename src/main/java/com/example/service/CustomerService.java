package com.example.service;

import com.example.model.Customer;

public class CustomerService {
    public void registerCustomer(Customer customer) {
        System.out.println("Customer registered: " + customer.getName());
    }
}
