package io.itjun.rabbitmq.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQCustomer {

    @RabbitListener(queues = "itjun")
    private void receive(String message) {
        log.info("收到的 message 是 {}", message);
    }

}