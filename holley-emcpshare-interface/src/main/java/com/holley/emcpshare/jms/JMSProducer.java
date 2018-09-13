package com.holley.emcpshare.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.holley.emcpshare.msg.MsgStartCharge;

/**
 * 消息的生产者（发送者）
 * 
 * @author liang
 */
public class JMSProducer {

    // 默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;    // 默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认连接地址
    // private static final String BROKEURL = "tcp://10.150.160.222:61616";; // 发送的消息数量
    private static final String BROKEURL = "tcp://localhost:61616";            // 发送的消息数量
    private static final int    SENDNUM  = 10;

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory;// 连接工厂
        Connection connection = null; // 连接
        Session session = null; // 会话 接受或者发送消息的线程
        Destination destination; // 消息的目的地

        MessageProducer messageProducer; // 消息生产者
        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            // 通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建session
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // 创建一个名称为HelloWorld的消息队列
            destination = session.createTopic("dcserver");
            // 创建消息生产者
            messageProducer = session.createProducer(destination);
            // 发送消息
            // sendObjectMessage(session, messageProducer);
            sendObjectMessage(session, messageProducer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            if (connection != null) {
                try {
                    connection.stop();
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 发送消息
     * 
     * @param session
     * @param messageProducer 消息生产者
     * @throws Exception
     */
    public static void sendObjectMessage(Session session, MessageProducer messageProducer) throws Exception {
        MsgStartCharge s = new MsgStartCharge();
        s.setCmdid("sc");
        // 创建一条文本消息
        ObjectMessage message = session.createObjectMessage(s);
        System.out.println("发送消息：Activemq 发送消息" + s.getCmdid());
        // 通过消息生产者发出消息
        messageProducer.send(message);
        session.commit();

    }

    /**
     * 发送消息
     * 
     * @param session
     * @param messageProducer 消息生产者
     * @throws Exception
     */
    public static void sendTestMessage(Session session, MessageProducer messageProducer) throws Exception {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            // 创建一条文本消息
            TextMessage message = session.createTextMessage("ActiveMQ 发送消息" + i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            // 通过消息生产者发出消息
            messageProducer.send(message);
            session.commit();
        }

    }

}
