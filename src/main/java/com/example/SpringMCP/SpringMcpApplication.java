package com.example.SpringMCP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMcpApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SpringMcpApplication.class, args);
        
        // Keep the app running, waiting for STDIO input
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}