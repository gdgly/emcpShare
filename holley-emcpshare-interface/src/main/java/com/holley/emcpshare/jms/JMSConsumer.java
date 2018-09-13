package com.holley.emcpshare.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.holley.emcpshare.msg.MsgStartCharge;

/**
 * 消息的消费者（接受者）
 * 
 * @author liang
 */
public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;    // 默认连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认连接密码
    // private static final String BROKEURL = "tcp://10.150.160.222:61616"; // 默认连接地址
    private static final String BROKEURL = "tcp://localhost:61616";

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory;// 连接工厂
        Connection connection = null;// 连接
        Session session;// 会话 接受或者发送消息的线程
        Destination destination;// 消息的目的地
        MessageConsumer messageConsumer;// 消息的消费者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);
        // connectionFactory.setTrustedPackages(Arrays.asList("com.holley.charging.share.msg".split(",")));
        connectionFactory.setTrustAllPackages(true);
        try {
            // 通过连接工厂获取连接
            connection = connectionFactory.createConnection();

            // 启动连接
            connection.start();
            // 创建session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // 创建一个连接HelloWorld的消息队列
            // destination = session.createQueue("HelloWorld");
            destination = session.createTopic("dcserver");
            // 创建消息消费者
            messageConsumer = session.createConsumer(destination);
            while (true) {
                // TextMessage textMessage = (TextMessage) messageConsumer.receive(100000);
                Message message = messageConsumer.receive(100000);
                if (message != null) {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage msg = (ObjectMessage) message;
                        Object obj = msg.getObject();
                        if (obj instanceof MsgStartCharge) {
                            MsgStartCharge mb = (MsgStartCharge) obj;
                            System.out.println(mb.getCmdid());
                        }
                    } else if (message instanceof TextMessage) {
                        TextMessage msg = (TextMessage) message;
                        System.out.println("收到的消息:" + msg.getText());
                    }
                }

            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
