package com.zlg.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @PROJECT_NAME: ActiveMQLearn
 * @PACKAGE_NAME: com.zlg.activemq
 * @USER: 33036
 * @DATE: 2020/10/22
 * 异步非阻塞方式（监听器onMessage()）
 * 订阅者或接收者通过MessageConsumer的setMessageListener(MessageListener listener)注册一个消息监听器，
 *      当消息到达之后，系统会自动调用监听器MessageListener的onMessage(Message message)方法。
 */
public class JmsConsumerListener {
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
        // 消费者通过监听的方式消费消息，是异步非阻塞的方式消费消息，如果有消息就执行，没有就结束
            //使用 MessageListener 接口实现匿名内部类
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                // 判断是否有消息，且消息是否为生产者生产的类型
                if (message != null && message instanceof TextMessage){
                    // 因为前面生产者创建的是文本类型消息，这里需要强转一下
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("*****TOPIC_NAME消费者受到信息：" + textMessage.getText());

                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 保证控制台一直运行，让主线程不要结束。因为一旦主线程结束了，其他的线程（如此处的监听消息的线程）也都会被迫结束。
        // 从如果有消息就执行，没有就结束，变成如果有消息就执行，没有就等待
        System.in.read();
        // 关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
