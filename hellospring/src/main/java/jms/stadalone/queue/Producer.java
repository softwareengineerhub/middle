package jms.stadalone.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by denys on 7/20/2017.
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Message message = session.createTextMessage("Hello "+System.currentTimeMillis());
        Destination destination = session.createQueue("helloQ");
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.send(message);
        connection.close();
        System.out.println("Message was sent");
    }
}
