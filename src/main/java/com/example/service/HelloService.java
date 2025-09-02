package com.example.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
@Component
public class HelloService {
    @PostConstruct
    public void init() {
        System.out.println("MyBean has been initialized!");
    }
    public String sayHello() {
        return  "Hello";
    }
}
