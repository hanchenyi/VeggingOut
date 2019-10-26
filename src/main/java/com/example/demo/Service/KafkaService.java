package com.example.demo.Service;

import com.example.demo.config.KafkaServerStreams;
import com.example.demo.controller.model.Greetings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class KafkaService {

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    private final KafkaServerStreams kafkaServerStreams;

    public KafkaService(KafkaServerStreams kafkaServerStreams) {
        this.kafkaServerStreams = kafkaServerStreams;
    }

    public void sendMessage(Greetings greetings) {
        logger.info("Sending greetings {}", greetings);
        MessageChannel messageChannel = kafkaServerStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

    }
}