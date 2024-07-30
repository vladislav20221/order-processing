package com.example.starter.config;

import jakarta.annotation.PostConstruct;
import liquibase.change.DatabaseChange;
import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@Configuration
@ConditionalOnClass({SpringLiquibase.class, DatabaseChange.class})
@ConditionalOnProperty(prefix = "spring.liquibase", name = "default-schema", matchIfMissing = true)
@AutoConfigureAfter({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Import({SchemaInitializer.SpringLiquibaseDependsOnPostProcessor.class})
public class SchemaInitializer {
    @Value("${spring.liquibase.default-schema}")
    private String schema;

    @Bean
    public SchemaInitBean schemaInitializerBean(final DataSource dataSource) {
        return new SchemaInitBean(dataSource, schema);
    }

    @RequiredArgsConstructor
    public static class SchemaInitBean {
        private final DataSource dataSource;
        private final String schema;

        @PostConstruct
        public void initialization() {
            try (Connection conn = dataSource.getConnection();
                 Statement statement = conn.createStatement()) {
                log.info("create DB schema '{}' if not exists.", schema);
                statement.execute("create schema if not exists " + schema);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to create schema '" + schema + "'", e);
            }
        }

    }

    @ConditionalOnBean(SchemaInitBean.class)
    static class SpringLiquibaseDependsOnPostProcessor extends AbstractDependsOnBeanFactoryPostProcessor {

        SpringLiquibaseDependsOnPostProcessor() {
            super(SpringLiquibase.class, SchemaInitBean.class);
        }

    }

}