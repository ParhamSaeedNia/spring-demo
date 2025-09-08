package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Customer {

    private String name = "Parham";

    @Autowired
    private Account account; // Spring will inject the Account bean automatically

    @PostConstruct
    public void init() {
        System.out.println("Customer initialized: " + name + " with account " + account.getAccountNumber());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }
}
