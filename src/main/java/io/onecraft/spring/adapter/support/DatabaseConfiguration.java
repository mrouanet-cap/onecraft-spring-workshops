package io.onecraft.spring.adapter.support;

import io.hypersistence.optimizer.HypersistenceOptimizer;
import io.hypersistence.optimizer.core.config.JpaConfig;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Database configuration
 *
 * @version 1.0
 */
@Configuration
public class DatabaseConfiguration {

    @Bean
    public HypersistenceOptimizer hypersistenceOptimizer(EntityManagerFactory entityManagerFactory) {
        return new HypersistenceOptimizer(new JpaConfig(entityManagerFactory));
    }
}
