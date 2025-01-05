package com.project.kafka;

import com.project.entity.WikimediaData;
import com.project.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 02/01/25
 */

@Service
public class KafkaDatabaseConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private  WikimediaRepository wikimediaRepository;


    @KafkaListener(topics = "wikimedia-recent-change", groupId = "myGroup")
    public void consume(String eventMessage) {
        log.info("Event Message Received into KafkaDatabaseConsumer consume() :: {}", eventMessage);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaRepository.save(wikimediaData);
    }

}
