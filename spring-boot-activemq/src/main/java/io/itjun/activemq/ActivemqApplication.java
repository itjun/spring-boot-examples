package io.itjun.activemq;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import io.itjun.activemq.client.ActiveMQClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ActivemqApplication {

    @Autowired
    ActiveMQClient client;

    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000; i++) {
            client.send("----itjun-----");
        }
        stopWatch.stop();
        log.info("发送消息耗时 {}", stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }

}