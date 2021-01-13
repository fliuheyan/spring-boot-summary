package com.cloud.mybatis;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        FlywayMigrationStrategy strategy = new FlywayMigrationStrategy() {
            @Override
            public void migrate(Flyway flyway) {
                flyway.clean();
                flyway.migrate();
            }
        };
        return strategy;
    }
}
