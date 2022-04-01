package com.example.agileup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
public class AgileupApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgileupApplication.class, args);
    }

}
