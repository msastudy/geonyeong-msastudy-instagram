package com.instagram.clone.user.query.domain.entity;

import com.instagram.clone.common.enums.UserStatus;
import com.instagram.clone.common.user.domain.event.UserCreateEvent;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@NoArgsConstructor
@Data
@Entity
public class UserEntity {

    @Id
    private String id;
    private String email;
    private String password;
    private String username;
    private String fullname;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    public UserEntity(UserCreateEvent userCreateEvent) {
        this.id = userCreateEvent.getId();
        this.email = userCreateEvent.getEmail();
        this.password = userCreateEvent.getPassword();
        this.username = userCreateEvent.getUsername();
        this.fullname = userCreateEvent.getFullname();
        this.userStatus = UserStatus.DEACTIVATION;
    }
}
