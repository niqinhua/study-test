package com.hua.spring.batch;

import com.hua.spring.batch.job.MessageMigrationJobConfiguration;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@EnableBatchProcessing(modular = true)
@SpringBootApplication
public class SpringBatchApplication {

    @Autowired
    JobRegistry jobRegistry;
    @Autowired
    JobLauncher jobLauncher;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchApplication.class, args);

    }

    @Bean
    public void startBatch(){
        String jobName="MyHelloBatchName";
        try {
            Job job = jobRegistry.getJob(jobName);
            JobExecution jobExecution = jobLauncher.run(job, createJobParams());
            if (!jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
                throw new RuntimeException(String.format("%s Job execution failed.", jobName));
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s Job execution failed.", jobName));
        }
    }

    private static JobParameters createJobParams() {
        return new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
    }

    @Bean
    public ApplicationContextFactory messageMigrationJobContext() {
        return new GenericApplicationContextFactory(MessageMigrationJobConfiguration.class);
    }


}
