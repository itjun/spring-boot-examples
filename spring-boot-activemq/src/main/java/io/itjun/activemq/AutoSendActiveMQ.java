package io.itjun.activemq;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import io.itjun.activemq.producer.ActiveMQProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AutoSendActiveMQ {

    @Autowired
    ActiveMQProducer producer;

    @PostConstruct
    @Scheduled(fixedRate = 100)
    public void run() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++)
            producer.send("----itjun.activemq-----");
        stopWatch.stop();
        log.info("发送消息耗时 {}", stopWatch.getTotalTimeMillis());
    }

}