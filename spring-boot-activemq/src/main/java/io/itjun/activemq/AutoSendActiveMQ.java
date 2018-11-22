package io.itjun.activemq;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import io.itjun.activemq.client.ActiveMQProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AutoSendActiveMQ {

    @Autowired
    ActiveMQProducer client;

    @PostConstruct
    @Scheduled(fixedDelay = 3 * 1000)
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10; i++) {
            client.send("----itjun-----");
        }
        stopWatch.stop();
        log.info("发送消息耗时 {}", stopWatch.getTotalTimeMillis());
    }

}