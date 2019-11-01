package com.example.demo.service;

import com.example.demo.config.TickerKafkaStream;
import com.example.demo.external.model.TickerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    private Logger logger = LoggerFactory.getLogger(KafkaListener.class);

    @StreamListener(TickerKafkaStream.INPUT)
    public void handleTickerData(@Payload TickerData data) {
        logger.info("Received ticker data: {}", data);
    }
}
