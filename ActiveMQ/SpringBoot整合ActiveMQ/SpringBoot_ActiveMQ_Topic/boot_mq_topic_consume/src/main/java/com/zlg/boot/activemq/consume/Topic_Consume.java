package com.zlg.boot.activemq.consume;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ_Topic
 * @PACKAGE_NAME: com.zlg.boot.activemq.consume
 * @USER: 33036
 * @DATE: 2020/11/2
 */
@Component
public class Topic_Consume {

    // 注册一个监听器。destination指定监听的主题。
    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("****主题消费者收到的消息：" + textMessage.getText());
    }
}
