package com.instagram.clone.user.command.command;

import com.instagram.clone.common.enums.Sex;
import com.instagram.clone.common.enums.UserStatus;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@ToString
public class UserUpdateCommand {

    @TargetAggregateIdentifier
    private String id;

    private String email;
    private String password;
    private String username;
    private String fullname;
    private String website;
    private String introduce;
    private Sex sex;
    private String profileUrl;
    private UserStatus userStatus;

    public UserUpdateCommand(final UserUpdateVerificationCommand userVerificationCommand) {
        this.id = userVerificationCommand.getId();
        this.email = userVerificationCommand.getEmail();
        this.password = userVerificationCommand.getPassword();
        this.username = userVerificationCommand.getUsername();
        this.fullname = userVerificationCommand.getFullname();
        this.website = userVerificationCommand.getWebsite();
        this.introduce = userVerificationCommand.getIntroduce();
        this.sex = userVerificationCommand.getSex();
        this.profileUrl = userVerificationCommand.getProfileUrl();
        this.userStatus = userVerificationCommand.getUserStatus();
    }
}
