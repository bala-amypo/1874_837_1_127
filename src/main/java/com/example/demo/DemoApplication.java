package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Main entry point for the Digital Complaint Prioritization Engine
 */
@SpringBootApplication
@ServletComponentScan   // IMPORTANT: Enables @WebServlet scanning
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
