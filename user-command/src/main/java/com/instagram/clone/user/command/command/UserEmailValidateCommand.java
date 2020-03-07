package com.instagram.clone.user.command.command;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@Getter
public class UserEmailValidateCommand {

    @TargetAggregateIdentifier
    private final String id;
}
