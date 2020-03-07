package com.instagram.clone.user.command.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.instagram.clone.common.user.domain.event.UserCreateEvent;
import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.user.command.command.UserCreateCommand;
import com.instagram.clone.user.command.command.UserEmailValidateCommand;
import com.instagram.clone.user.command.command.UserCreateVerificationCommand;
import com.instagram.clone.common.user.domain.event.UserEmailValidateEvent;
import com.instagram.clone.user.command.command.UserUpdateVerificationCommand;
import com.instagram.clone.user.command.event.UserUpdateVerificationEvent;
import com.instagram.clone.user.command.event.UserVerificationEvent;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Aggregate(repository = "userAggregateEventSourcingRepository")
@Data
public class UserAggregate {

    @AggregateIdentifier
    private String id;

    private String email;
    private String password;
    private String username;
    private String fullname;
    private UserStatus userStatus;

    @CommandHandler
    public UserAggregate(UserCreateVerificationCommand userVerificationCommand) {
        log.info("userVerificationCommand => {}", userVerificationCommand);
        if(!validate(userVerificationCommand)) {
            throw new RuntimeException("verification");
        }
        apply(new UserVerificationEvent(userVerificationCommand));
    }

    @CommandHandler
    public void handle(UserCreateCommand userCreateCommand) {
        log.info("userCreateCommand => {}", userCreateCommand);
        apply(UserCreateEvent.builder()
                .email(userCreateCommand.getEmail())
                .fullname(userCreateCommand.getFullname())
                .id(userCreateCommand.getId())
                .password(userCreateCommand.getPassword())
                .username(userCreateCommand.getUsername())
                .build());
    }

    @CommandHandler
    public void handle(UserEmailValidateCommand userEmailValidateCommand) {
        log.info("userEmailValidateCommand => {}", userEmailValidateCommand);
        apply(new UserEmailValidateEvent(userEmailValidateCommand.getId()));
    }

    @CommandHandler
    public void handle(UserUpdateVerificationCommand userUpdateVerificationCommand) {
        if(!validate(userUpdateVerificationCommand)) {
            throw new RuntimeException("verification");
        }
        apply(new UserUpdateVerificationEvent(userUpdateVerificationCommand));
    }

    private boolean validate(UserCreateVerificationCommand userVerificationCommand) {
        // TODO: 요구사항에 맞게 필드 체크.
        return true;
    }

    private boolean validate(UserUpdateVerificationCommand userVerificationCommand) {
        // TODO: 요구사항에 맞게 필드 체크.
        return true;
    }

    @EventSourcingHandler
    public void on(UserVerificationEvent userVerificationEvent) {
        this.id = userVerificationEvent.getId();
        this.userStatus = userVerificationEvent.getUserStatus();
    }

    @EventSourcingHandler
    public void on(UserCreateEvent userCreateEvent) {
        this.fullname = userCreateEvent.getFullname();
        this.username = userCreateEvent.getUsername();
        this.password = userCreateEvent.getPassword();
        this.email = userCreateEvent.getEmail();
        this.userStatus = UserStatus.DEACTIVATION;
        log.info("this => {}", toString());
    }

    @EventSourcingHandler
    public void on(UserEmailValidateEvent userEmailValidateEvent) {
        this.userStatus = UserStatus.ACTIVATION;
    }

//    @EventSourcingHandler
//    public void on(UserUpdateVerificationEvent userUpdateVerificationEvent) {
//        this.userStatus = userVerificationEvent.getUserStatus();
//    }
}
