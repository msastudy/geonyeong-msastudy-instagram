package com.instagram.clone.notification.aggregate.listener;

import com.instagram.clone.common.user.domain.event.UserCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@Component
@ProcessingGroup("notification")
public class UserEvnetListener {

    @EventHandler
    public void handle(UserCreateEvent userCreateEvent) {
        log.info("userCreateEvent => {}", userCreateEvent);
        // TODO: 외부 email req & res 서비스 클래스 만들어서 메소드 수행.

    }
}
