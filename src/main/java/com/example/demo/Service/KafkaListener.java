package com.example.demo.Service;

import com.example.demo.config.KafkaServerStreams;
import com.example.demo.controller.model.Greetings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    private Logger logger = LoggerFactory.getLogger(KafkaListener.class);

    @StreamListener(KafkaServerStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        logger.info("Received greetings: {}", greetings);
    }
}
