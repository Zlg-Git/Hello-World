package com.zlg.activemq.lastingtopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq.lastingtopic
 * @USER: 33036
 * @DATE: 2020/10/30
 */
public class jmsProducer {
    // 连接地址
    private static final String ACTIVEMQ_URL  = "tcp://47.95.14.216:61616";
    // 消费者需要消费的主题
    public static final String TOPIC_NAME = "topic-ZLG";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer messageProducer = session.createProducer(topic);

        // 持久化topic 可以不写 默认是开启的
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 设置持久化topic之后再启动连接
        connection.start();
        for (int i = 1; i < 4; i++) {
            TextMessage textMessage = session.createTextMessage("topic_name--" + i);

            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();

        System.out.println("*****TOPIC_NAME消息发布到MQ完成*****");
    }
}
