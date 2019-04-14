package com.veontomo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import server.presistence.ItemRepository;
import server.presistence.ItemRepositoryImpl;

@SpringBootApplication
public class TodoApplication {
    
    @Bean
    public ItemRepository userRepository() {
        return new ItemRepositoryImpl();
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    public static void main(String[] args) {
        SpringApplication.run(new Class[] {TodoApplication.class, SecurityConfig.class}, args);
    }
 

}
