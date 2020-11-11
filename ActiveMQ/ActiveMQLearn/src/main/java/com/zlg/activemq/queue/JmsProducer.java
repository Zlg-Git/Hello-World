package com.zlg.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq
 * @USER: 33036
 * @DATE: 2020/10/20
 * 生产者
 */
public class JmsProducer {
    // Linux 系统升级上的连接地址
    public static final String ACTIVEMQ_URL = "tcp://47.95.14.216:61616";
    // 使用本机的嵌入式 broker（嵌入式 mq 服务器）
    public static final String ACTIVEMQ_URLS = "tcp://localhost:61616";
    // 生产者的队列名称
    public static final String QUEUE_NAME = "queue01";


    public static void main(String[] args) throws JMSException {
        // 1、创建连接工厂,使用默认的用户名，密码（都是admin）
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 2、通过连接工厂，获取 connection 并启动
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3、创建会话 session
        //两个参数，一个叫事务、一个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4、创建目的地（具体是队列还是主题topic）
        // 队列 返回值也可以用 Destination(目的地) Destination为队列与主题的父类，类似于集合中的Collection
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5、创建消息生产者
        MessageProducer messageProducer = session.createProducer(queue);
        // 设置是否持久化 可有可无的，不设置的话默认为持久化
            // DeliveryMode.NON_PERSISTENT: 非持久化  DeliveryMode.PERSISTENT：持久化 不设置默认为持久化
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 6、通过 MessageProducer 生产3条消息，发送到 MQ 的队列中
        for (int i = 1; i <=3 ; i++) {
            // 6.1、创建消息
            TextMessage textMessage = session.createTextMessage("textMsg---" + i);// 可以理解为类似于字符串
            // 6.2、通过 MessageProducer 发送给 MQ
            messageProducer.send(textMessage);
            // MapMessage类型消息
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1", "mapMsg---" + i);
            messageProducer.send(mapMessage);
        }
        // 7、关闭资源
        messageProducer.close();
        session.close();
        connection.close();


        // 8、验证是否成功
        System.out.println("*****QUEUE_NAME消息发布到MQ完成*****");
    }
}

