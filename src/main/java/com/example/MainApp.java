package com.example;

import com.example.config.AppConfig;
import com.example.model.Customer;
import com.example.service.DatabaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== APPLICATION STARTING ===");
        System.out.println("Creating ApplicationContext...");
        
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println("ApplicationContext created successfully!");
            System.out.println("Notice: @Import brought in DatabaseConfig beans, but lazy singleton was NOT created yet.\n");

            System.out.println("=== @IMPORT AND BEAN INJECTION DEMONSTRATION ===");
            System.out.println("Getting DatabaseService (which uses imported database beans)...");
            
            // Get DatabaseService - this will show how beans from imported config are used
            DatabaseService databaseService = context.getBean(DatabaseService.class);
            System.out.println("\nDatabaseService created! Now calling connectToDatabase():");
            databaseService.connectToDatabase();
            
            System.out.println("\nDatabase info: " + databaseService.getDatabaseInfo());
            
            System.out.println("\n=== LAZY LOADING DEMONSTRATION ===");
            System.out.println("About to request lazy singleton bean for the first time...");
            
            // Get lazy singleton bean - this will trigger its creation
            Customer lazySingletonCustomer = context.getBean("singletonCustomer", Customer.class);
            System.out.println("Lazy singleton name: " + lazySingletonCustomer.getName());
            
            System.out.println("\nRequesting the same lazy singleton bean again...");
            Customer lazySingletonCustomer2 = context.getBean("singletonCustomer", Customer.class);
            System.out.println("Second request - same instance: " + (lazySingletonCustomer == lazySingletonCustomer2));
            
            System.out.println("\n=== PROTOTYPE BEAN DEMONSTRATION ===");
            System.out.println("About to request prototype bean...");
            
            // Get prototype bean
            Customer prototypeCustomer1 = context.getBean("prototypeCustomer", Customer.class);
            System.out.println("Prototype name: " + prototypeCustomer1.getName());
            
            System.out.println("\nRequesting another prototype bean...");
            Customer prototypeCustomer2 = context.getBean("prototypeCustomer", Customer.class);
            System.out.println("Second prototype - different instance: " + (prototypeCustomer1 != prototypeCustomer2));
        }
        
        System.out.println("\n=== APPLICATION ENDING ===");
    }
}
