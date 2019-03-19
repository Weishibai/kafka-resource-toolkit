package com.nicklaus.kafka.consumer;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.google.common.collect.Maps;

/**
 * consumer config
 *
 * @author weishibai
 * @date 2019/03/19 10:13 AM
 */
@Configuration
@EnableKafka
@Conditional(ConsumerConditional.class)
@PropertySource(value = {"classpath:kafka_consumer_config.properties"}, ignoreResourceNotFound = true)
public class KafkaConsumerConfiguration {

    @Bean
    public Map<String, String> consumerProperties(Environment env) {
        final Map<String, String> properties = Maps.newHashMap();
        properties.put("bootstrap.servers", env.getProperty("bootstrap.servers"));
        properties.put("client.id", env.getProperty("client.id"));
        properties.put("group.id", env.getProperty("group.id"));
        properties.put("enable.auto.commit", env.getProperty("enable.auto.commit"));
        properties.put("auto.commit.interval.ms", env.getProperty("auto.commit.interval.ms"));
        properties.put("session.timeout.ms", env.getProperty("session.timeout.ms"));
        properties.put("auto.offset.reset", env.getProperty("auto.offset.reset"));
        properties.put("num.consumer.fetchers", env.getProperty("num.consumer.fetchers"));
        properties.put("rebalance.backoff.ms", env.getProperty("rebalance.backoff.ms"));
        properties.put("key.deserializer", env.getProperty("key.deserializer"));
        properties.put("value.deserializer", env.getProperty("value.deserializer"));
        return properties;
    }

    @Bean
    public ConsumerFactory consumerFactory(Map<String, String> consumerProperties) {
        return new DefaultKafkaConsumerFactory(consumerProperties);
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory(ConsumerFactory consumerFactory, Environment env) {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        //noinspection unchecked
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(Boolean.valueOf(env.getProperty("batch.consume")));
        return factory;
    }

}
