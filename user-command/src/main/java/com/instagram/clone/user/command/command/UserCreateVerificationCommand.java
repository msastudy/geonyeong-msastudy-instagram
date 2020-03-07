package com.instagram.clone.user.command.command;

import com.instagram.clone.common.user.domain.vo.UserCreateRequest;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Getter
@ToString
public class UserCreateVerificationCommand extends VerificationCommand {

    @TargetAggregateIdentifier
    private final String id;

    public UserCreateVerificationCommand(final UserCreateRequest userCreateRequest) {
        this.id = UUID.randomUUID().toString();
        this.email = userCreateRequest.getEmail();
        this.password = userCreateRequest.getPassword();
        this.username = userCreateRequest.getUsername();
        this.fullname = userCreateRequest.getFullname();
    }

}
