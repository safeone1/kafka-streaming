package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.events.PageEvent;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PageEventController {

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/publish")    
    public PageEvent publish(String name, String topic) {
        PageEvent event = new PageEvent(name, Math.random() > .5 ? "Safae" : "Yassine", new Date(),
                new Random().nextInt(10000));

            streamBridge.send(topic, event);
            return event;
        }
}
