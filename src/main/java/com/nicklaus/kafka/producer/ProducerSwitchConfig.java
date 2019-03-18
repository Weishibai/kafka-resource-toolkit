package com.nicklaus.kafka.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * producer switch config
 *
 * @author weishibai
 * @date 2019/03/18 11:06 PM
 */
@ConfigurationProperties(prefix = "kafka.producer")
public class ProducerSwitchConfig {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
