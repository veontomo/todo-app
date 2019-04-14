package com.veontomo.todo.server;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import server.presistence.ItemRepository;
import server.presistence.ItemRepositoryImpl;

@SpringBootApplication
public class Server {
    @Bean
    public ItemRepository userRepository() {
        return new ItemRepositoryImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(new Class[] { Server.class, ResourceServerConfig.class, AuthorizationServerConfig.class, SecurityConfig.class });
        app.run(args);
    }

}
