package com.zlg.boot.activrmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
// 开启定时投递
@EnableScheduling
public class BootMqTopicProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMqTopicProduceApplication.class, args);
    }

}
