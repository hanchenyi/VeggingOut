package com.example.demo.controller;

import com.example.demo.constant.CoinType;
import com.example.demo.external.TickerListener;
import com.example.demo.external.model.TickerData;
import com.example.demo.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaController {

    @Autowired
    TickerListener tickerListener;

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/hello")
    public String hello() {
        TickerData data = tickerListener.getTickerData(CoinType.BTC.name());
        return "Hello World!";
    }

}