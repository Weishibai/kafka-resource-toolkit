package com.nicklaus.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * starter
 *
 * @author weishibai
 * @date 2019/03/18 7:07 PM
 */
@SpringBootApplication(scanBasePackages = "com.nicklaus.kafka")
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
