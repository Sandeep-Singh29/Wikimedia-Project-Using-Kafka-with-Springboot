package com.project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("wikimedia-recent-change")
                .build();
    }

}
