package com.instagram.clone.user.command.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instagram.clone.user.command.command.UserCreateCommand;
import com.instagram.clone.user.command.command.UserEmailValidateCommand;
import com.instagram.clone.user.command.command.UserCreateVerificationCommand;
import com.instagram.clone.user.command.command.UserUpdateCommand;
import com.instagram.clone.user.command.command.UserUpdateVerificationCommand;
import javax.swing.text.html.ObjectView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserCommandService {

    private final CommandGateway commandGateway;

    public void createUser(UserCreateVerificationCommand userVerificationCommand) {
        try {
            Object o = commandGateway.sendAndWait(userVerificationCommand);
            log.info("o => {}", new ObjectMapper().writeValueAsString(o));
            o = commandGateway.sendAndWait(new UserCreateCommand(userVerificationCommand));
            log.info("o => {}", new ObjectMapper().writeValueAsString(o));
        } catch (CommandExecutionException e) {
            // TODO: 검증, 생성 실패에 Exception 사용하여 후 처리.
            // TODO: axon server에서 throwable 발생하면, 자기네 Exception으로 반환하는듯... try-catch를 2중으로 할지 혹은 한개의 catch문에서 분기 필요할듯.
            log.error("e => " + e);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void validateEmail(UserEmailValidateCommand userEmailValidateCommand) {
        try {
            commandGateway.sendAndWait(userEmailValidateCommand);
        } catch (CommandExecutionException e) {
            log.error("e => " + e);
        }
    }

    public void updateUser(UserUpdateVerificationCommand userUpdateVerificationCommand) {
        try {
            commandGateway.sendAndWait(userUpdateVerificationCommand);
            // TODO: 사진 업로드 작업 추가
            commandGateway.sendAndWait(new UserUpdateCommand(userUpdateVerificationCommand));
        } catch (CommandExecutionException e) {
            log.error("e => " + e);
        }
    }
}
