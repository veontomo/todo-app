package com.veontomo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {TodoApplication.class, SecurityConfig.class}, args);
    }
 

}
