package com.instagram.clone.common.user.domain.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@NoArgsConstructor
@ToString
public class UserCreateEvent {

    private String id;
    private String email;
    private String password;
    private String username;
    private String fullname;

    @Builder
    public UserCreateEvent(String id, String email, String password, String username, String fullname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.fullname = fullname;
    }
}
