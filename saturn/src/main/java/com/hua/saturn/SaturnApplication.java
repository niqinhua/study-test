package com.hua.saturn;

import com.vip.saturn.job.springboot.GenericSpringBootSaturnApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SaturnApplication extends GenericSpringBootSaturnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaturnApplication.class, args);
    }


}
