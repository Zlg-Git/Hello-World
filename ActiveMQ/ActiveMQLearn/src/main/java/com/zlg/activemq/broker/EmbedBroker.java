package com.zlg.activemq.broker;

import org.apache.activemq.broker.BrokerService;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq.broker
 * @USER: 33036
 * @DATE: 2020/10/31
 * 嵌入式broke的启动类
 * 用ActiveMQ Broker作为独立的消息服务器来构建Java应用。
 *
 * 简单来说就是Java版的 mq 服务器，不需要使用外部的 mq 服务器，自己就是一个小型服务器
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        // ActiveMQ也支持在vm中通信基于嵌入的broker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
