package com.lolitaflamme.coffeefindermysqlmvc.config;

import com.lolitaflamme.coffeefindermysqlmvc.domain.Coffee;
import com.lolitaflamme.coffeefindermysqlmvc.repository.CoffeeRepository;
import com.lolitaflamme.coffeefindermysqlmvc.websocket.WebSocketHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class CoffeeRetriever {
    private final CoffeeRepository coffeeRepository;
    private final WebSocketHandler webSocketHandler;

    @Bean
    Consumer<List<Coffee>> retrieveAllCoffees() {
        return coffees -> {
            coffeeRepository.deleteAll();
            coffeeRepository.saveAll(coffees);
            sendPositions();
        };
    }

    private void sendPositions() {
        if (coffeeRepository.count() > 0) {
            for (WebSocketSession session : webSocketHandler.getSessions()) {
                try {
                    session.sendMessage(new TextMessage(coffeeRepository.findAll().toString())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
