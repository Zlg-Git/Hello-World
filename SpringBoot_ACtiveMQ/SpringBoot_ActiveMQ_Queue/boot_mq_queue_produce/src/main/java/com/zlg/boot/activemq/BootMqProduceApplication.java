package com.zlg.boot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主启动类
 */

@SpringBootApplication
// 开启(激活)定时投递
@EnableScheduling
public class BootMqProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMqProduceApplication.class, args);

    }

}
