package io.itjun.rabbitmq;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import io.itjun.rabbitmq.producter.RabbitMQProducter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RabbitMQApplication {

    @Autowired
    RabbitMQProducter client;

    @Bean
    public Queue test() {
        return new Queue("itjun");
    }

    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10; i++)
            client.send("----itjun-----");
        stopWatch.stop();
        log.info("发送消息耗时 {}", stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
