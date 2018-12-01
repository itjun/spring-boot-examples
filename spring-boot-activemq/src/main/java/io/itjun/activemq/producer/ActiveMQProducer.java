package io.itjun.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message) {
        jmsTemplate.convertAndSend("itjun", message);
    }

}