package com.example.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TickerKafkaStream.class)
public class KafkaStreamConfig {
}
