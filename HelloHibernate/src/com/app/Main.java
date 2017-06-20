package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();

        Session session = (Session) em;
        session.getTransaction().begin();
        Person person = new Person();
        person.setName("Name2");
        person.setAge(2);

        session.save(person);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
