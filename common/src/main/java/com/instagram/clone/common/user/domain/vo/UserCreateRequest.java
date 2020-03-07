package com.instagram.clone.common.user.domain.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@NoArgsConstructor
@ToString
public class UserCreateRequest {

    private String email;
    private String password;
    private String username;
    private String fullname;
}
