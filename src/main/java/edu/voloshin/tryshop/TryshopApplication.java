package edu.voloshin.tryshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class TryshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryshopApplication.class, args);
    }
}
