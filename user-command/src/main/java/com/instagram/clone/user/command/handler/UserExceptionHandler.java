package com.instagram.clone.user.command.handler;

import com.instagram.clone.user.command.exception.UserVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.instagram.clone.user.command.aggregate")
public class UserExceptionHandler {

    @ExceptionHandler(value = UserVerificationException.class)
    public void handler(UserVerificationException e) {
        log.info("UserVerificationException => {}", e);
    }
}
