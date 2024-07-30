package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InventoryService {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(InventoryService.class, args);
        context.registerShutdownHook();
    }

}