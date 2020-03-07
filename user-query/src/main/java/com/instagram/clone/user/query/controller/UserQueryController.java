package com.instagram.clone.user.query.controller;

import com.instagram.clone.user.query.domain.entity.UserEntity;
import com.instagram.clone.user.query.service.UserQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by geonyeong.kim on 2020-03-07
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping
    public List<UserEntity> readUsers() {
        return userQueryService.readUsers();
    }

    @GetMapping("/{id}")
    public UserEntity readUser(@PathVariable String id) {
        return userQueryService.readUser(id);
    }
}
