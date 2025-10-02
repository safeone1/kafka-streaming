package com.example.demo.handlers;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.internals.TimeWindow;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.events.PageEvent;

@Component
public class PageEventHandler {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("Page event received: " + input.toString());
            System.out.println("Page name: " + input.name());
        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> new PageEvent(Math.random() > 0.5 ? "P1" : "P2", Math.random() > 0.5 ? "C1" : "C2", new Date(),
                10 + new Random().nextInt(10000));
    }
    
    @Bean
    public Function<KStream<String, PageEvent>, KStream<String, Long>> kStreamFunction() {
        return (input) -> input
                .filter((key, value) -> value.duration() > 100)
                .map((key, value) -> new KeyValue<>(value.name(), value.duration()))
                .groupByKey(Grouped.with(Serdes.String(), Serdes.Long()))
                .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                .count(Materialized.as("counts-store"))
                .toStream()
                .map((k, v) -> new KeyValue<>(k.key(), v));

    }
}
