package com.example.utils;

import com.example.domain.entity.AuditTimestamp;
import com.example.inventory.entity.ProductEntity;
import lombok.experimental.UtilityClass;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class ProductGenerator {
    private static final Faker FAKER = new Faker(Locale.ENGLISH, ThreadLocalRandom.current());

    public static ProductEntity create() {
        return ProductEntity.builder()
                .id(UUID.randomUUID())
                .name(FAKER.book().title())
                .description(FAKER.book().genre())
                .quantity(FAKER.number().numberBetween(50, 300))
                .price(FAKER.number().numberBetween(20_000, 500_000))
                .soldCount(FAKER.number().numberBetween(0, 50))
                .timestamp(AuditTimestamp.of(LocalDateTime.now(), LocalDateTime.now()))
                .isBlocked(FAKER.bool().bool())
                .build();
    }

}