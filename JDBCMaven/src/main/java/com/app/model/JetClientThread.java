package com.app.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/27/2017.
 */
public class JetClientThread  extends Thread {
    private long delay;
    private String modelName;

    public JetClientThread(long delay, String modelName) {
        this.delay = delay;
        this.modelName = modelName;
    }

    @Override
    public void run() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();

        //SELECT * FROM TABLE FOR UPDATE

        Jet jet = em.find(Jet.class,1);
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<delay){
        }
        jet.setModel(modelName);
        em.merge(jet);
        tr.commit();
    }
}
