package com.zlg.boot.activemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.UUID;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ
 * @PACKAGE_NAME: com.zlg.boot.activemq.produce
 * @USER: 33036
 * @DATE: 2020/11/1
 * 队列生产者
 */

@Component
public class Queue_Produce {
    // Jms 模板
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 配置 ConfigBean 中的队列目的地
    @Resource(name = "queue")
    private Queue queue;

    // 发送消息
    public void produceMessage() {
        // 转换消息格式并发送 一参是目的地，二参是消息内容
        jmsMessagingTemplate.convertAndSend(queue,"****"+ UUID.randomUUID().toString().substring(0,6));
    }
    private int a = 1;
    // 使用定时投递  需求：每隔10秒发送一次信息
    @Scheduled(fixedDelay = 10000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"**"+ a +"**Scheduled" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("****produceMsgScheduled send OK" + a);
        a++;
    }
}
