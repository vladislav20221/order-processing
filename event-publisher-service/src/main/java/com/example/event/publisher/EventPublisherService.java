package com.example.event.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EventPublisherService {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(EventPublisherService.class, args);
        context.registerShutdownHook();
    }

}