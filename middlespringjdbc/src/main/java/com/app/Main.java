package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by denys on 8/1/2017.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/config.xml");
        PersonDao personDao = ctx.getBean(PersonDao.class);
        String name=personDao.getNameById(1);
        System.out.println("name="+name);
        int age = personDao.getAgeById(1);
        System.out.println("age="+age);
        List<Person> persons = personDao.getAll();
        for(Person p: persons){
            System.out.println(p);
        }
        while(true){

        }
    }
}
