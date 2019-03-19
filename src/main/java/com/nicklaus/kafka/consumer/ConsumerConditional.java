package com.nicklaus.kafka.consumer;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * producer load conditional
 *
 * @author weishibai
 * @date 2019/03/18 7:25 PM
 */
public class ConsumerConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return Boolean.valueOf(context.getEnvironment().getProperty("kafka.consumer.on"));
    }
}
