package ch3.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denys on 7/25/2017.
 */
public class Sample3 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ch3/ch3-config.xml");
        MessageData3 messageData3 = (MessageData3) ctx.getBean("messageData3");
        messageData3.makeAction();
        //messageData3.makeAction(1);

    }
}
