package com.example.demo.service;

import com.example.demo.config.TickerKafkaStream;
import com.example.demo.external.model.TickerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class KafkaService {

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    private final TickerKafkaStream tickerKafkaStream;

    public KafkaService(TickerKafkaStream kafkaServerStreams) {
        this.tickerKafkaStream = kafkaServerStreams;
    }

    @Async("TickerExecutor")
    public void sendTickerData(TickerData tickerData) {
        logger.info("Sending ticker data {}", tickerData);
        MessageChannel messageChannel = tickerKafkaStream.outbound();
        messageChannel.send(MessageBuilder
                .withPayload(tickerData)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}