package com.nicklaus.kafka.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * producer listener
 *
 * @author weishibai
 * @date 2019/03/18 6:54 PM
 */
public class KafkaProducerListener implements ProducerListener {

    @Override
    public void onSuccess(String s, Integer integer, Object o, Object o2, RecordMetadata recordMetadata) {

    }

    @Override
    public void onError(String s, Integer integer, Object o, Object o2, Exception e) {

    }

    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }
}
