package com.example.demo.controller;

import com.example.demo.Service.KafkaService;
import com.example.demo.controller.model.Greetings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/produce")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void produce() {
        long timeStamp = System.currentTimeMillis();
        Greetings greetings = new Greetings("message sending at " + timeStamp, timeStamp);
        kafkaService.sendMessage(greetings);
    }
}