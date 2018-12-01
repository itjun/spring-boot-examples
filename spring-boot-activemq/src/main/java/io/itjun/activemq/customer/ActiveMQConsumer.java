package io.itjun.activemq.customer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActiveMQConsumer {

    @JmsListener(destination = "itjun")
    public void receive(String message) {
        log.info("收到 {}", message);
    }

}