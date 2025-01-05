package com.project;

import com.project.kafka.WikimediaChangesProdcuer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class, args);
        System.out.println("Kafka-Producer Running....");
    }

    @Autowired
    private  WikimediaChangesProdcuer wikimediaChangesProdcuer;

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProdcuer.sendMessage();
    }
}