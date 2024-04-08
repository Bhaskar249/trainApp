package com.cloudbees.trainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.cloudbees.controllers", "com.cloudbees.service", "com.cloudbees.models", "com.cloudbees.repository"})
@EnableJpaRepositories("com.cloudbees.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.cloudbees.models")
public class TrainAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainAppApplication.class, args);
    }

}
