package com.instagram.clone.common.user.domain.vo;

import com.instagram.clone.common.enums.Sex;
import com.instagram.clone.common.enums.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@NoArgsConstructor
@ToString
public class UserUpdateRequest {

    private String id;
    private String fullname;
    private String username;
    private String email;
    private UserStatus userStatus;
    private String website;
    private String introduce;
    private Sex sex;
    private String profileUrl;
}
