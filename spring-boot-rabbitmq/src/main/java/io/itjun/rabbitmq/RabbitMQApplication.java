package io.itjun.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class RabbitMQApplication {

    @Bean
    public Queue test() {
        return new Queue("itjun");
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
