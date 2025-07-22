package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
TAKEN FROM 1
The contents and structure of this class containing the main method were taken from https://spring.io/guides/gs/spring-boot
 */

// TAKEN FROM START 1
@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello, backend!");
        };
    }

}
// TAKEN FROM END 1