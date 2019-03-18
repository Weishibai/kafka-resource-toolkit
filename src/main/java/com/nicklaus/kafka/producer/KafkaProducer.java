package com.nicklaus.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

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


    public void send() {

    }






}
