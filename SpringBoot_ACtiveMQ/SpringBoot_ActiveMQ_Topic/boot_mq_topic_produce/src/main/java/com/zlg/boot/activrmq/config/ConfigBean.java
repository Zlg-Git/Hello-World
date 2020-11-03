package com.zlg.boot.activrmq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ_Topic
 * @PACKAGE_NAME: com.zlg.boot.activrmq.config
 * @USER: 33036
 * @DATE: 2020/11/2
 * 主题生产者
 */
@Component
// 自动配置jms
@EnableJms
public class ConfigBean {
    // 注入配置文件中的 myTopic
    @Value("${myTopic}")
    private String myTopic;

    // 定义存放消息的队列
    @Bean
    public ActiveMQTopic topic(){
        return new ActiveMQTopic(myTopic);
    }

}
