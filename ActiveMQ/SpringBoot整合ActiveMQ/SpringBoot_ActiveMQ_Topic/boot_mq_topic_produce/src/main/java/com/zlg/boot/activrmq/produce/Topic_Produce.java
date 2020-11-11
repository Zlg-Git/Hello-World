package com.zlg.boot.activrmq.produce;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ_Topic
 * @PACKAGE_NAME: com.zlg.boot.activrmq.produce
 * @USER: 33036
 * @DATE: 2020/11/2
 */
@Component
public class Topic_Produce {
    // Jms 模板
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 配置 ConfigBean 中的主题目的地
    @Resource(name = "topic")
    private Topic topic;

    // 定时任务 每10秒发送一次
    @Scheduled(fixedDelay = 10000)
    public void produceTopic(){
        jmsMessagingTemplate.convertAndSend(topic, "*****主题消息:" + UUID.randomUUID().toString().substring(0, 6));
        System.out.println("*******发送成功");
    }
}
