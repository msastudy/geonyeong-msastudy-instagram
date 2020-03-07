package com.instagram.clone.user.command.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@RequiredArgsConstructor
@ToString
public class UserCreateCommand {
    @TargetAggregateIdentifier
    private final String id;

    private final String email;
    private final String password;
    private final String username;
    private final String fullname;

    public UserCreateCommand(final UserCreateVerificationCommand userVerificationCommand) {
        this.id = userVerificationCommand.getId();
        this.email = userVerificationCommand.getEmail();
        this.password = userVerificationCommand.getPassword();
        this.username = userVerificationCommand.getUsername();
        this.fullname = userVerificationCommand.getFullname();
    }
}
