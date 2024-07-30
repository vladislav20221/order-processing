package com.example.test.containers;

import com.example.test.model.PostgresContainerConfig;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DataJdbcTest
@Testcontainers
public abstract class PostgresInitialization {
    private static final DockerImageName IMAGE = DockerImageName.parse("postgres:15-alpine");
    @Container
    private static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>(IMAGE)
            .withDatabaseName(PostgresContainerConfig.DATABASE)
            .withUsername(PostgresContainerConfig.USERNAME)
            .withPassword(PostgresContainerConfig.PASSWORD);

    @DynamicPropertySource
    static void configureProperties(final DynamicPropertyRegistry registry) {
        registry.add("data-source.url-postgres", POSTGRES::getJdbcUrl);
        registry.add("data-source.username", POSTGRES::getUsername);
        registry.add("data-source.password", POSTGRES::getPassword);
    }

}