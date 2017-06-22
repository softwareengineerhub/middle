package com.app;

import com.app.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 6/22/2017.
 */
public class EnheritenceExample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Parent parent = new Parent();
        parent.setName("P1");

        Child child = new Child();
        child.setName("Ch1");
        child.setSecondName("Ch1.SecondName1");

        ChildA childA = new ChildA();
        childA.setName("ChildA");
        childA.setAge(10);

        em.persist(parent);
        em.persist(child);
        em.persist(childA);

        em.getTransaction().commit();
    }

}
