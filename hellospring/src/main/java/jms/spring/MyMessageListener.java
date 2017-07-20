package jms.spring;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by denys on 7/20/2017.
 */
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
