package com.instagram.clone.user.query.listener;

import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.common.user.domain.event.UserCreateEvent;
import com.instagram.clone.common.user.domain.event.UserEmailValidateEvent;
import com.instagram.clone.user.query.domain.entity.UserEntity;
import com.instagram.clone.user.query.repository.UserRepository;
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
@ProcessingGroup("users")
public class UserQueryListener {

    private final UserRepository userRepository;

    @EventHandler
    public void handle(UserCreateEvent userCreateEvent) {
        // TODO: 쿼리 DB 정해지면 insert 쿼리 질의 -> 일단 postgresql로 수행.
        log.info("UserCreateEvent => {}", userCreateEvent);
        log.info("userRepository => {}", userRepository);
        UserEntity userEntity = new UserEntity(userCreateEvent);
        userRepository.save(userEntity);
    }

    @EventHandler
    public void handle(UserEmailValidateEvent userEmailValidateEvent) {
        // TODO: 쿼리 DB 정해지면 update 쿼리 질의 -> 일단 postgresql로 수행.
        log.info("UserEmailValidateEvent => {}", userEmailValidateEvent);
        userRepository.updateUserStatus(userEmailValidateEvent.getId(), UserStatus.ACTIVATION.name());
    }
}
