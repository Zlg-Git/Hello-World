package com.zlg.boot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ
 * @PACKAGE_NAME: com.zlg.boot.activemq.config
 * @USER: 33036
 * @DATE: 2020/11/1
 * 配置目的地的bean
 */
// 让spring管理的注解，相当于spring中在xml 中写了个bean
@Component
// 开启 Jms 适配（开启消息队列）
@EnableJms  // 自动配置jms
public class ConfigBean {
    // 注入配置文件中的 myqueue
    @Value("${myqueue}")
    private String myQueue;

    // 定义存放消息的队列
    @Bean(name = "queue")   // bean id=""  class="…"
    public ActiveMQQueue queue(){
        return new ActiveMQQueue(myQueue);
    }
}
