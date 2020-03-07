package com.instagram.clone.user.command.event;

import com.instagram.clone.common.enums.Sex;
import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.user.command.command.UserUpdateVerificationCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@NoArgsConstructor
@Getter
@ToString
public class UserUpdateVerificationEvent {

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
    
    public UserUpdateVerificationEvent(UserUpdateVerificationCommand userUpdateVerificationCommand) {
        this.id = userUpdateVerificationCommand.getId();
        this.email = userUpdateVerificationCommand.getEmail();
        this.password = userUpdateVerificationCommand.getPassword();
        this.username = userUpdateVerificationCommand.getUsername();
        this.fullname = userUpdateVerificationCommand.getFullname();
        this.website = userUpdateVerificationCommand.getWebsite();
        this.introduce = userUpdateVerificationCommand.getIntroduce();
        this.sex = userUpdateVerificationCommand.getSex();
        this.profileUrl = userUpdateVerificationCommand.getProfileUrl();
        this.userStatus = userUpdateVerificationCommand.getUserStatus();
    }
}
