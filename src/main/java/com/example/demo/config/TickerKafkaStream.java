package com.example.demo.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TickerKafkaStream {

    String INPUT = "bitcoin-in";
    String OUTPUT = "bitcoin-out";

    @Input(INPUT)
    SubscribableChannel inbound();

    @Output(OUTPUT)
    MessageChannel outbound();

}
