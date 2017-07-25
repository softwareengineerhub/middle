package ch2.sample2;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denys on 7/25/2017.
 */
public class Sample2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ch2/ch2-config.xml");

        //MessageData2 messageData2 = (MessageData2) ctx.getBean("messageData2");
        //messageData2.makeAction();

        MessageData2 messageData2 = (MessageData2) ctx.getBean("messageData2Proxy");
        messageData2.makeAction();
    }
}
