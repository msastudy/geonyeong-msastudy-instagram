package com.instagram.clone.notification.aggregate.configuration;

import org.axonframework.config.Configurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by geonyeong.kim on 2020-03-08
 */
@Configuration
public class NotificationConfiguration {

    @Autowired
    public void configureEventProcessing(Configurer configurer) {
        configurer.eventProcessing()
                .registerTrackingEventProcessor("notification",
                        org.axonframework.config.Configuration::eventStore,
                        c -> TrackingEventProcessorConfiguration.forSingleThreadedProcessing()
                                .andBatchSize(1))
                ;
    }
}
