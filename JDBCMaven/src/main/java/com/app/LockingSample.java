package com.app;

import com.app.model.Jet;
import com.app.model.JetClientThread;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/27/2017.
 */
public class LockingSample {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        Jet jet = new Jet();
        jet.setModel("M1");
        jet.setPrice(100);
        jet.setManufacture("Embrier");
        em.persist(jet);
        tr.commit();

        Thread t1 = new JetClientThread(10000, "Jet1");
        Thread t2 = new JetClientThread(15000, "Jet2");
        Thread t3 = new JetClientThread(20000, "Jet3");
        t1.start();
        t2.start();
        t3.start();
    }
}
