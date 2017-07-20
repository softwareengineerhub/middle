package jms.stadalone.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by denys on 7/20/2017.
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //Connection connection = cf.createConnection("user", "password");
        Connection connection = cf.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("helloQ");
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
