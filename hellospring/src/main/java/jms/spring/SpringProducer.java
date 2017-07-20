package jms.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denys on 7/20/2017.
 */
public class SpringProducer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/jms-spring.xml");
    }
}
