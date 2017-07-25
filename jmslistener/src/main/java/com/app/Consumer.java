package com.app;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by denys on 7/20/2017.
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("helloQ");
        MessageConsumer messageConsumer = session.createConsumer(destination);
        messageConsumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                System.out.println("onMessage");
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    String text= null;
                    try {
                        text = textMessage.getText();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Consumed: "+text);
                }
            }
        });
        /*while(true){
            System.out.println("Before");
            messageConsumer.
            Message message = messageConsumer.receive();
            System.out.println("After");
            if(message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                String text=textMessage.getText();
                System.out.println("Consumed: "+text);
            }
        }*/
    }
}
