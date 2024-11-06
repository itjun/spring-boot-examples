package io.itjun.event;

import org.springframework.context.ApplicationEvent;

/**
 * 定义一个报警事件，属性是报警实体类
 */
public class AlarmEvent extends ApplicationEvent {

    private final String message;

    public AlarmEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
