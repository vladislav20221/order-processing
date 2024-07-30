package com.example.shopping.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShoppingCartService {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(ShoppingCartService.class, args);
        context.registerShutdownHook();
    }

}