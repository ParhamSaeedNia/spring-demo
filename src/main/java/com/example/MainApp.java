package com.example;

import com.example.config.AppConfig;
import com.example.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

        System.out.println("=== SINGLETON SCOPE DEMONSTRATION ===");
        
        // Get singleton bean
        Customer singletonCustomer1 = context.getBean("singletonCustomer", Customer.class);
        System.out.println("Initial singleton name: " + singletonCustomer1.getName());
        
        // Call setName on singleton
        singletonCustomer1.setName("Modified Singleton Name");
        System.out.println("After setName on singleton: " + singletonCustomer1.getName());
        
        // Get the same singleton bean again
        Customer singletonCustomer2 = context.getBean("singletonCustomer", Customer.class);
        System.out.println("Second getBean for singleton: " + singletonCustomer2.getName());
        System.out.println("Are they the same instance? " + (singletonCustomer1 == singletonCustomer2));
        
        System.out.println("\n=== PROTOTYPE SCOPE DEMONSTRATION ===");
        
        // Get prototype bean
        Customer prototypeCustomer1 = context.getBean("prototypeCustomer", Customer.class);
        System.out.println("Initial prototype name: " + prototypeCustomer1.getName());
        
        // Call setName on prototype
        prototypeCustomer1.setName("Modified Prototype Name");
        System.out.println("After setName on prototype: " + prototypeCustomer1.getName());
        
        // Get a new prototype bean
        Customer prototypeCustomer2 = context.getBean("prototypeCustomer", Customer.class);
        System.out.println("Second getBean for prototype: " + prototypeCustomer2.getName());
        System.out.println("Are they the same instance? " + (prototypeCustomer1 == prototypeCustomer2));
        }
    }
}
