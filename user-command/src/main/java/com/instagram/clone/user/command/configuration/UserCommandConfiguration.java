package com.instagram.clone.user.command.configuration;

import com.instagram.clone.user.command.aggregate.UserAggregate;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Slf4j
@Configuration
public class UserCommandConfiguration {

    @Bean
    public EventSourcingRepository<UserAggregate> userAggregateEventSourcingRepository(
            EventStore eventStore) {
        return EventSourcingRepository.builder(UserAggregate.class).eventStore(eventStore).build();
    }

}
