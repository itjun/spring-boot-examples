package io.itjun.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.itjun.rabbitmq.config.RabbitMQConfig;

@EnableScheduling
@SpringBootApplication
public class RabbitMQApplication {

    @Bean
    public Queue test() {
        return new Queue(RabbitMQConfig.Queue_Itjun);
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }

}
