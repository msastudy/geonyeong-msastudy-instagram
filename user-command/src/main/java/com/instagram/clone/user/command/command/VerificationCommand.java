package com.instagram.clone.user.command.command;

import lombok.Getter;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
public class VerificationCommand {

    protected String email;
    protected String password;
    protected String username;
    protected String fullname;
}
