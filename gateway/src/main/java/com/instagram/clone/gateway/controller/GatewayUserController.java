package com.instagram.clone.gateway.controller;

import com.instagram.clone.common.user.domain.vo.UserCreateRequest;
import com.instagram.clone.gateway.service.GatewayUserService;
import java.io.IOException;
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
@RequestMapping("/api/v1/gateway/user")
public class GatewayUserController {

    private final GatewayUserService gatewayUserService;

    @GetMapping
    public void readUser() throws IOException {
        log.info("gatewayReadUser");
        gatewayUserService.readUser().execute();
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest userCreateRequest) throws IOException {
        log.info("userCreateRequest => {}", userCreateRequest);
        gatewayUserService.createUser(userCreateRequest).execute();
    }

    @PutMapping
    public void updateUser() throws IOException {
        log.info("gatewayUpdateUser");
        gatewayUserService.updateUser().execute();

    }

    @GetMapping("/{id}/emailvalidation")
    public void validateEmail(@PathVariable String id) throws IOException {
        log.info("userId => {}", id);
        log.info("gatewayvalidateEmail");
        gatewayUserService.validateUserEmail(id).execute();
    }
}
