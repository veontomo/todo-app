package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.veontomo.todo.persistence.ItemRepository;
import com.veontomo.todo.persistence.ItemRepositoryImpl;

@SpringBootApplication
public class Server {
    @Bean
    public ItemRepository userRepository() {
        return new ItemRepositoryImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[] { Server.class }, args);
    }

}
