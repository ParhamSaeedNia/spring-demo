package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String accountNumber;

    public Account() {
        this.accountNumber = "ACC" + System.currentTimeMillis();
        System.out.println("Account bean created with accountNumber: " + accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
