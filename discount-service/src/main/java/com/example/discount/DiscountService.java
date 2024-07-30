package com.example.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DiscountService {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(DiscountService.class, args);
        context.registerShutdownHook();
    }

}