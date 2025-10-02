package com.example.demo.handlers;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.events.PageEvent;

@Component
public class PageEventHandler {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("Page event received: " + input);
            System.out.println("Page name: " + input.name());
        };
    }
}
