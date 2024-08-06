package com.example.inventory.service.impl;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@ConditionalOnEnabledHealthIndicator("order-service")
public class OrderServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Health.Builder builder = Health.up();
        builder.withDetail("random", ThreadLocalRandom.current().nextBoolean());
        builder.withDetail("message", "hello world");
        return builder.build();
    }

}