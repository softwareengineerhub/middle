package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denys on 7/18/2017.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");
        //Processor processor = context.getBean("defaultProcessor", Processor.class);
        //Processor processor = context.getBean("xmlProcessor", Processor.class);
        //processor.process();
        //Processor processor = new DefaultProcessorImpl();
        //DataService dataService = new DataService(processor);
        DataService dataService = context.getBean(com.app.DataService.class);
        dataService.makeAction();
    }
}
