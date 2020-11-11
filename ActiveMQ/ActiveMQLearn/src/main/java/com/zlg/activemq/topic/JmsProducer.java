package com.zlg.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq
 * @USER: 33036
 * @DATE: 2020/10/20
 */
public class JmsProducer {
    // 连接地址
    public static final String ACTIVEMQ_URL = "tcp://192.168.158.129:61616";
    // 生产者的主题名称
    public static final String TOPIC_NAME = "topic-zlg";


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
            // 主题 返回值也可以用 Destination(目的地) Destination为队列与主题的父类，类似于集合中的Collection
        Topic topic = session.createTopic(TOPIC_NAME);
        // 5、创建消息生产者
        MessageProducer messageProducer = session.createProducer(topic);
        // 6、通过 MessageProducer 生产3条消息，发送到 MQ 的队列中
        for (int i = 1; i <= 3 ; i++) {
            // 6.1、创建消息
            TextMessage textMessage = session.createTextMessage("TOPIC_NAME---" + i);
            // 6.2、通过 MessageProducer 发送给 MQ
            messageProducer.send(textMessage);
        }
        // 7、关闭资源
        messageProducer.close();
        session.close();
        connection.close();

        // 8、验证是否成功
        System.out.println("*****TOPIC_NAME消息发布到MQ完成*****");
    }
}
