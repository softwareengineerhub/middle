package com.app.dao.impl;

import com.app.dao.DAO;
import com.app.model.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/20/2017.
 */
public class JPADAOImpl implements DAO{

    @Override
    public void saveAnimal(Animal animal) {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
    }
}
