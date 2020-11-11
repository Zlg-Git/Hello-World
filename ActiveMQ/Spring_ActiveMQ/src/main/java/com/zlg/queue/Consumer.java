package com.zlg.queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: Spring_ActiveMQ
 * @PACKAGE_NAME: com.zlg.service
 * @USER: 33036
 * @DATE: 2020/11/1
 * 消费者
 */
@Service
public class Consumer {
    @Resource
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        // 读取配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 没有严格按照 Spring 的规范书写，直接全部写到了 Service 层，本应该写在 active 层
        // 获取本类 相当于 Produce produce = new Produce();
//        Consumer consumer = applicationContext.getBean(Consumer.class);
        // 使用类名首字母小写与上面一样
         Consumer consumer = (Consumer) applicationContext.getBean("consumer");
        // 获取消息并自动转换格式
        String receive = (String) consumer.jmsTemplate.receiveAndConvert();
        System.out.println(receive);
    }
}
