package com.zlg.queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


/**
 * @PROJECT_NAME: Spring_ActiveMQ
 * @PACKAGE_NAME: com.zlg.service
 * @USER: 33036
 * @DATE: 2020/11/1
 * 生产者
 */
@Service
public class Produce {
    @Resource
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        // 读取配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 没有严格按照 Spring 的规范书写，直接全部写到了 Service 层，本应该写在 active 层
        // 获取本类 相当于 Produce produce = new Produce();
        Produce produce = applicationContext.getBean(Produce.class);
        // 使用匿名内部类实现消息生产
        produce.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("***Spring和ActiveMQ的整合case 匿名内部类.....");
                return textMessage;
            }
        });
        // 使用 Lambda 表达式
        produce.jmsTemplate.send((Session session) -> {
            TextMessage textMessage = session.createTextMessage("***Spring和ActiveMQ的整合case Lambda表达式.....");
            return textMessage;
        });
        System.out.println("*****发送完毕");
    }
}
