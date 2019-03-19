package com.nicklaus.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.nicklaus.kafka.ObjectMapperUtils;

/**
 * kafka producer wrapper
 *
 * @author weishibai
 * @date 2019/03/18 6:27 PM
 */
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(String topic, byte[] message) {
        //noinspection unchecked
        kafkaTemplate.send(topic, message);
    }

    public <T> void send(String topic, T message) {
        send(topic, ObjectMapperUtils.writeValue(message));
    }

    public ListenableFuture<SendResult<?, ?>> asyncSend(String topic, byte[] message) {
        //noinspection unchecked
        return kafkaTemplate.send(topic, message);
    }

    public <T> ListenableFuture<SendResult<?, ?>> asyncSend(String topic, T message) {
        return asyncSend(topic, ObjectMapperUtils.writeValue(message));
    }

}
