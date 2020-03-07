package com.instagram.clone.user.command.exception;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
public class UserVerificationException extends RuntimeException {

    public UserVerificationException() {
    }

    public UserVerificationException(String message) {
        super(message);
    }

    public UserVerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
