package com.instagram.clone.common.user.domain.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@Getter
public class UserEmailValidateEvent {

    private final String id;

}

