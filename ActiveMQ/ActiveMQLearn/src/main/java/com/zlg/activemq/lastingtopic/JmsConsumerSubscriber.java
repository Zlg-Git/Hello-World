package com.zlg.activemq.lastingtopic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq.lastingtopic
 * @USER: 33036
 * @DATE: 2020/10/30
 */
public class JmsConsumerSubscriber {
    // 连接地址
    private static final String ACTIVEMQ_URL  = "tcp://47.95.14.216:61616";
    // 消费者需要消费的主题
    public static final String TOPIC_NAME = "topic-ZLG";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        // 设置客户端ID，向MQ服务器注册自己的名称
        connection.setClientID("zs");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建一个 topic 消息订阅者对象。一参是topic，二参订阅者名称
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "res");
        // 之后再开启连接
        connection.start();
        while (true){
            // 获取消息
            TextMessage message = (TextMessage)topicSubscriber.receive();
            // 判断是否有消息，且消息是否为生产者生产的类型
            if (message != null && message instanceof TextMessage) {
                System.out.println("*****订阅者收到信息：" + message.getText());
            } else {
                break;
            }
        }
        topicSubscriber.close();
        session.close();
        connection.close();
    }
}
