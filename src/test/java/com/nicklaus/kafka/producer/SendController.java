package com.nicklaus.kafka.producer;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicklaus.kafka.consumer.MessageDTO;

/**
 * send msg controller
 *
 * @author weishibai
 * @date 2019/03/19 11:15 AM
 */
@RestController
public class SendController {

    private static AtomicInteger counter = new AtomicInteger();

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/send/{topic}")
    public void sendMessage(@PathVariable String topic) {
        producer.send(topic, new MessageDTO(String.valueOf(counter.getAndIncrement()), "nicklaus"));
    }

}
