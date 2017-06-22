package com.app;

import com.app.model.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/22/2017.
 */
public class TransactionSample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Animal animal = new Animal();
            animal.setAge(1);
            animal.setName("N1");
            em.persist(animal);
            Animal animal2 = new Animal();
            animal2.setAge(2);
            animal2.setName("N2");
            em.persist(animal2);
            String str = null;
            str.toString();
            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
            ex.printStackTrace();
        } finally {
            if(tr.isActive()) {
                tr.commit();
            }
            em.close();
        }

    }
}
