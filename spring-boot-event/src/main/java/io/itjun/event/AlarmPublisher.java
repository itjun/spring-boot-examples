package io.itjun.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class AlarmPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(String message) {
        AlarmEvent alarmEvent = new AlarmEvent(this, message);
        publisher.publishEvent(alarmEvent);
    }

}
