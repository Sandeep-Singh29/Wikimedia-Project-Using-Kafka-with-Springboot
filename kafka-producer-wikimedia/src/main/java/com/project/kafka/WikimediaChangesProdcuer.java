package com.project.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@Service
@Slf4j
public class WikimediaChangesProdcuer {

    private String kafkaTopic = "wikimedia-recent-change";

    private final KafkaTemplate<String,String> kafkaTemplate;

    public WikimediaChangesProdcuer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
       //to read real time Stream Data from wikimedia, we use event source
        EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate,kafkaTopic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }

}
