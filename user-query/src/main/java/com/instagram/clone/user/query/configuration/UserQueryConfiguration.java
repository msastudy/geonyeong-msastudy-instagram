package com.instagram.clone.user.query.configuration;

import org.axonframework.config.Configurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Configuration
public class UserQueryConfiguration {

    @Autowired
    public void configureEventProcessing(Configurer configurer) {
        configurer.eventProcessing()
                .registerTrackingEventProcessor("users",
                        org.axonframework.config.Configuration::eventStore,
                        c -> TrackingEventProcessorConfiguration.forSingleThreadedProcessing()
                                .andBatchSize(1))
        ;
    }

}
