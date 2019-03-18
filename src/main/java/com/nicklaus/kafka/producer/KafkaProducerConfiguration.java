package com.nicklaus.kafka.producer;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

import com.google.common.collect.Maps;

/**
 * kafka producer config relevant
 * need a file named kafka_producer_config.properties
 *
 * @author weishibai
 * @date 2019/03/18 6:28 PM
 */
@Configuration
@Conditional(ProducerConditional.class)
@PropertySource(value = {"classpath:kafka_producer_config.properties"}, ignoreResourceNotFound = true)
public class KafkaProducerConfiguration {

    @Bean
    public Map<String, String> producerProperties(Environment env) {
        final Map<String, String> properties = Maps.newHashMap();
        properties.put("bootstrap.servers", env.getProperty("bootstrap.servers"));
        properties.put("group.id", env.getProperty("group.id"));
        properties.put("retries", env.getProperty("retries"));
        properties.put("batch.size", env.getProperty("batch.size"));
        properties.put("linger.ms", env.getProperty("linger.ms"));
        properties.put("buffer.memory", env.getProperty("buffer.memory"));
        properties.put("key.serializer", env.getProperty("key.serializer"));
        properties.put("value.serializer", env.getProperty("value.serializer"));
        return properties;
    }

    @Bean
    public ProducerListener producerListener() {
        return new KafkaProducerListener();
    }

    @Bean
    public ProducerFactory producerFactory(Map<String, String> producerProperties) {
        return new DefaultKafkaProducerFactory(producerProperties);
    }

    @Bean
    public KafkaTemplate kafkaTemplate(ProducerFactory producerFactory) {
        //noinspection unchecked
        return new KafkaTemplate<>(producerFactory, true);
    }

    @Bean
    public KafkaProducer kafkaProducer() {
        return new KafkaProducer();
    }


}
