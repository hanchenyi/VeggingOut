package com.example.demo.service;

import com.example.demo.constant.CoinType;
import com.example.demo.external.TickerListener;
import com.example.demo.external.model.TickerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TickerService {

    private final KafkaService kafkaService;

    public TickerService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @Autowired
    TickerListener tickerListener;

    @Scheduled(fixedRate = 1000)
    public void getTickerData() {
        TickerData tickerData = tickerListener.getTickerData(CoinType.BTC.name());
        kafkaService.sendTickerData(tickerData);
    }
}
