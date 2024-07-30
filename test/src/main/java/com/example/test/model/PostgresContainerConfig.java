package com.example.test.model;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PostgresContainerConfig {
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DATABASE = "order-processing-test";
    public static final String SCHEMAS = "product";
}