package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final String databaseUrl;
    private final String databaseUsername;
    private final String databasePassword;
    private final String environmentName;

    @Autowired
    public DatabaseService(@Qualifier("databaseUrl") String databaseUrl, 
                          @Qualifier("databaseUsername") String databaseUsername, 
                          @Qualifier("databasePassword") String databasePassword,
                          @Qualifier("environmentName") String environmentName) {
        System.out.println("*** DATABASE SERVICE CREATED ***");
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
        this.environmentName = environmentName;
    }

    public void connectToDatabase() {
        System.out.println("=== " + environmentName + " ===");
        System.out.println("Connecting to database:");
        System.out.println("URL: " + databaseUrl);
        System.out.println("Username: " + databaseUsername);
        System.out.println("Password: " + maskPassword(databasePassword));
    }

    public String getDatabaseInfo() {
        return environmentName + " - Database URL: " + databaseUrl + ", Username: " + databaseUsername;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    private String maskPassword(String password) {
        return "*".repeat(password.length());
    }
}
