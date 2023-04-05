package com.cta.training.studenttracker.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.cta.training.studenttracker.domain"})
@EnableJpaRepositories(basePackages = {"com.cta.training.studenttracker.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
