package com.instagram.clone.user.query.repository;

import com.instagram.clone.user.query.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_entity SET user_status = :userStatus where id = :id", nativeQuery = true)
    public void updateUserStatus(@Param("id") String id, @Param("userStatus") String userStatus);

}
