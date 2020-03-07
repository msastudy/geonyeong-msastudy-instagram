package com.instagram.clone.user.command.controller;

import com.instagram.clone.common.user.domain.vo.UserCreateRequest;
import com.instagram.clone.common.user.domain.vo.UserUpdateRequest;
import com.instagram.clone.user.command.command.UserEmailValidateCommand;
import com.instagram.clone.user.command.command.UserCreateVerificationCommand;
import com.instagram.clone.user.command.command.UserUpdateVerificationCommand;
import com.instagram.clone.user.command.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserCommandController {

    private final UserCommandService userCommandService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) {
        final UserCreateVerificationCommand userVerificationCommand = new UserCreateVerificationCommand(userCreateRequest);
        log.info("userVerificationCommand => {}", userVerificationCommand);
        userCommandService.createUser(userVerificationCommand);
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        final UserUpdateVerificationCommand userUpdateVerificationCommand = new UserUpdateVerificationCommand(userUpdateRequest);
        userCommandService.updateUser(userUpdateVerificationCommand);
    }

    @GetMapping("/{id}/emailvalidation")
    public void validateEmail(@PathVariable String id) {
        UserEmailValidateCommand userEmailValidateCommand = new UserEmailValidateCommand(id);
        userCommandService.validateEmail(userEmailValidateCommand);
    }
}
