package com.nicklaus.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.nicklaus.kafka.ObjectMapperUtils;

/**
 * kafka consumer
 *
 * @author weishibai
 * @date 2019/03/19 10:59 AM
 */
@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "my_topic")
    public void consume(@Payload byte[] message, @Headers MessageHeaders headers) {
        LOGGER.info("received message: {}", ObjectMapperUtils.readValue(message, MessageDTO.class));
    }

}
