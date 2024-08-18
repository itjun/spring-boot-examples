package io.itjun.rabbitmq;

import io.itjun.rabbitmq.producter.RabbitMQProducer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
public class AutoSendRabbitMQ {

    @Autowired
    RabbitMQProducer producer;

    @PostConstruct
    @Scheduled(fixedDelay = 30 * 1000)
    public void run() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            producer.send("----itjun.rabbitmq-----");
        }
        stopWatch.stop();
        log.info("发送消息耗时 {}", stopWatch.getTotalTimeMillis());
    }

}
