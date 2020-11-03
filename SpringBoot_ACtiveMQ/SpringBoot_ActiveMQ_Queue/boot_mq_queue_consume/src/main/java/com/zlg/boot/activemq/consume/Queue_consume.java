package com.zlg.boot.activemq.consume;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ
 * @PACKAGE_NAME: com.zlg.boot.activemq.consume
 * @USER: 33036
 * @DATE: 2020/11/1
 * 队列消费者
 */
@Component
public class Queue_consume {
    // 注册一个监听器。destination指定监听的主题。
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println(" ***消费者收到消息***"+textMessage.getText());
    }
}
