package com.instagram.clone.user.command.event;

import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.user.command.command.UserCreateVerificationCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@NoArgsConstructor
@ToString
public class UserVerificationEvent {

    private String id;
    private String email;
    private String password;
    private String username;
    private String fullname;
    private UserStatus userStatus;

    public UserVerificationEvent(final UserCreateVerificationCommand userVerificationCommand) {
        this.id = userVerificationCommand.getId();
        this.email = userVerificationCommand.getEmail();
        this.password = userVerificationCommand.getPassword();
        this.username = userVerificationCommand.getUsername();
        this.fullname = userVerificationCommand.getFullname();
        this.userStatus = UserStatus.VERIFICATIOND;
    }
}
