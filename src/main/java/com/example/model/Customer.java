package com.example.model;

import jakarta.annotation.PostConstruct;

public class Customer {

    private String name;
    private Account account;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    @PostConstruct
    public void init() {
        // Automatically create an account after Customer is initialized
        this.account = new Account();
        System.out.println("Customer initialized: " + name + " with account " + account.getAccountNumber());
    }
}
