package com.zlg.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq
 * @USER: 33036
 * @DATE: 2020/10/22
 * 消费者之同步阻塞方式(receive)
 * 订阅者或接收者抵用MessageConsumer的receive()方法来接收消息，receive方法在能接收到消息之前（或超时之前）将一直阻塞。
 */
public class JmsConsumerReceive {
    // 连接地址
    private static final String ACTIVEMQ_URL  = "tcp://192.168.158.129:61616";
    // 消费者需要消费的主题
    public static final String TOPIC_NAME = "topic-zlg";

    public static void main(String[] args) throws JMSException, IOException {
        // 创建连接工厂，使用默认的用户名
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 通过连接工厂，获取 connection 并启动
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建session会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建消息消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        // 消费者通过同步堵塞的方式消费消息
        while (true){
            // 因为前面生产者创建的是文本类型消息，这里需要强转一下
                // receive() 内可以设置 long 类型参数，使用超时等待，单位为毫秒，超过设置时间自动销毁生产者；如果不设置则一直等待，需要手动结束
            TextMessage message = (TextMessage) messageConsumer.receive();
            // 判断是否有消息，且消息是否为生产者生产的类型
            if (message != null && message instanceof TextMessage) {
                System.out.println("*****消费者受到信息：" + message.getText());
            } else {
                break;
            }
        }
        // 关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
