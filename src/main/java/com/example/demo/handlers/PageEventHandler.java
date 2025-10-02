package com.example.demo.handlers;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.kafka.streams.kstream.KStream;
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

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> new PageEvent(Math.random() > 0.5 ? "P1" : "P2", Math.random() > 0.5 ? "C1" : "C2", new Date(),
                10 + new Random().nextInt(10000));
    }
    
    @Bean
    public Function<KStream<String, PageEvent>, KStream<String, String>> kStreamFunction() {
        return (input) -> input
                .filter((key, value) -> value.duration() > 1000)
                .mapValues(value -> "Page event filtered: " + value);
                
    }
}
