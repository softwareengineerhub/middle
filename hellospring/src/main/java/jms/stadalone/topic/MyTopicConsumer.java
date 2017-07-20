package jms.stadalone.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by denys on 7/20/2017.
 */
public class MyTopicConsumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //Connection connection = cf.createConnection("user", "password");
        Connection connection = cf.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("heeloTopic");
        MessageConsumer messageConsumer = session.createConsumer(destination);
        while (true) {
            Message msg = messageConsumer.receive();
            System.out.println(msg);
            long start = System.currentTimeMillis();
            //while(System.currentTimeMillis()-start<20000){
            //}
        }
    }

}
