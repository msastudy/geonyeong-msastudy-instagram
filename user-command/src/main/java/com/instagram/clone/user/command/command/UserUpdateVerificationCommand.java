package com.instagram.clone.user.command.command;

import com.instagram.clone.common.enums.Sex;
import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.common.user.domain.vo.UserUpdateRequest;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@ToString
public class UserUpdateVerificationCommand extends VerificationCommand {

    @TargetAggregateIdentifier
    private String id;

    private String website;
    private String introduce;
    private Sex sex;
    private String profileUrl;
    private UserStatus userStatus;

    public UserUpdateVerificationCommand(UserUpdateRequest userUpdateRequest) {
        this.id = userUpdateRequest.getId();
        this.fullname = userUpdateRequest.getFullname();
        this.username = userUpdateRequest.getUsername();
        this.email = userUpdateRequest.getEmail();
        this.userStatus = userUpdateRequest.getUserStatus();
        this.website = userUpdateRequest.getWebsite();
        this.introduce = userUpdateRequest.getIntroduce();
        this.sex = userUpdateRequest.getSex();
        this.profileUrl = userUpdateRequest.getProfileUrl();
    }
}
