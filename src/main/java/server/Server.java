package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.veontomo.todo.persistence.ItemRepository;
import com.veontomo.todo.persistence.ItemRepositoryImpl;

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
        SpringApplication.run(new Class[] { Server.class, SecurityConfig.class }, args);
    }

}
