package com.example.model;

public class Account {
    private String accountNumber;

    public Account() {
        this.accountNumber = "ACC" + System.currentTimeMillis();
        System.out.println("Account created with accountNumber: " + accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
