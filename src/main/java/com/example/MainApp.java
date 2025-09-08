package com.example;

import com.example.config.AppConfig;
import com.example.model.Customer;
import com.example.service.DatabaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== SPRING PROFILES DEMONSTRATION ===");
        
        // Test different profiles
        testProfile("default", "No Profile (Default)");
        testProfile("dev", "Development Profile");
        testProfile("stage", "Staging Profile");
        testProfile("prod", "Production Profile");
        
        System.out.println("\n=== APPLICATION ENDING ===");
    }
    
    private static void testProfile(String profile, String description) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TESTING: " + description);
        System.out.println("=".repeat(60));
        
        // Set the active profile
        System.setProperty("spring.profiles.active", profile);
        
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            // Set the active profile for this context
            context.getEnvironment().setActiveProfiles(profile);
            context.register(AppConfig.class);
            context.refresh();
            
            System.out.println("ApplicationContext created with profile: " + profile);
            
            // Get DatabaseService - this will show profile-specific beans
            DatabaseService databaseService = context.getBean(DatabaseService.class);
            System.out.println("\nDatabaseService created! Environment: " + databaseService.getEnvironmentName());
            databaseService.connectToDatabase();
            
            System.out.println("\nDatabase info: " + databaseService.getDatabaseInfo());
            
        } catch (Exception e) {
            System.out.println("Error with profile " + profile + ": " + e.getMessage());
        }
        
        // Clear the system property
        System.clearProperty("spring.profiles.active");
    }
}
