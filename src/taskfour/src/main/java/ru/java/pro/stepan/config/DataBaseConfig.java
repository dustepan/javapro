package ru.java.pro.stepan.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author SDudin
 */
@Configuration
public class DataBaseConfig {
    @Bean
    HikariConfig config() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/test_db");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("1111");
        hikariConfig.setSchema("public");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return hikariConfig;
    }

    @Bean
    HikariDataSource hikariDataSource(HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    Connection connection(HikariDataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }
}
