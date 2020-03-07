package com.instagram.clone.user.query.service;

import com.instagram.clone.user.query.domain.entity.UserEntity;
import com.instagram.clone.user.query.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserQueryService {

    private final UserRepository userRepository;

    public List<UserEntity> readUsers() {
        // TODO: 쿼리 DB가 정해지면 거기서 조회하여 반환. -> 일단 postgresql로 수행.
        List<UserEntity> users = userRepository.findAll();
        users.forEach(item -> {log.info("item -> {}", item);});
        return users;
    }

    public UserEntity readUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }
}
