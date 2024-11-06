package io.itjun.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 定义一个报警事件，属性是报警实体类
 */
@Slf4j
@Component
public class AlarmListener implements ApplicationListener<AlarmEvent> {

    @Async
    @Override
    public void onApplicationEvent(AlarmEvent event) {
        log.info("收到事件消息 {}", event.getMessage());
    }

}
