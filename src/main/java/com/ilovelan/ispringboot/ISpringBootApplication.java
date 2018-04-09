package com.ilovelan.ispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ISpringBootApplication {

    public String index() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(ISpringBootApplication.class, args);
    }
}
