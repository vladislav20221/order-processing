package com.example.order.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrderProcessingService {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(OrderProcessingService.class, args);
        context.registerShutdownHook();
    }

}