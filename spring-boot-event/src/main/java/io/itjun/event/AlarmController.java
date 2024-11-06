package io.itjun.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmPublisher alarm;

    @GetMapping("/publish")
    public String publish() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String message = now.format(formatter);
        alarm.publish(message);
        return message;
    }

}
