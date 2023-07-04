package com.example.content;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Application API" , version = "1.0", description = "Managment API"))
public class ContentApplication {


    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
        log.info("hello");
    }

}
