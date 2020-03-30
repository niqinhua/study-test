package com.hua.spring.batch;

import com.hua.spring.batch.job.MessageMigrationJobConfiguration;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@EnableBatchProcessing(modular = true)
@SpringBootApplication
public class SpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }
    @Bean
    public ApplicationContextFactory messageMigrationJobContext() {
        return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
    }


}
