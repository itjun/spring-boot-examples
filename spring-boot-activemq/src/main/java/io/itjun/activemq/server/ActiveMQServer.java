package io.itjun.activemq.server;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActiveMQServer {

    private long count;

    @JmsListener(destination = "itjun")
    public void receive(String message) {
        if (count == 10000)
            count = 0;
        log.info("收到 {},count {}", message, count++);
    }

}