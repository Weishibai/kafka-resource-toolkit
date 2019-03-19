package com.nicklaus.kafka.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * producer listener
 *
 * @author weishibai
 * @date 2019/03/18 6:54 PM
 */
public class KafkaProducerListener implements ProducerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerListener.class);

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        LOGGER.info("send topic {} partition {} success", topic, partition);
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception e) {
        LOGGER.warn("send topic {} partition {} error: {}", topic, partition, e);
    }

    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }
}
