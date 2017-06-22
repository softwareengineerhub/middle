package com.app;

import com.app.dao.DAO;
import com.app.dao.impl.JDBCDAOImpl;
import com.app.dao.impl.JPADAOImpl;
import com.app.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        //----persiste()
        //daoProcessor();
        //dogProcessor();
       // catProcessor();
       // carProcessor();
        //computerProcessor();
        //mergeDogExample();
        //findCompositePKComputerExample();
        listenerAnimalExample();
    }


    private static void daoProcessor(){
        //DAO dao = new JDBCDAOImpl();
        DAO dao = new JPADAOImpl();
        Animal a = new Animal();
        a.setName("A");
        a.setAge(1);
        dao.saveAnimal(a);
    }

    private static void dogProcessor(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Dog dog = new Dog();
        dog.setColorType(ColorType.BLACK);
        dog.setFeight(2.4f);
        dog.setName("Dog1");
        em.persist(dog);
        em.getTransaction().commit();
    }

    private static void catProcessor(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Cat cat = new Cat();
        cat.setName("N1");
        cat.setColorType(ColorType.GREEN);
        cat.setAge(1);
        em.persist(cat);

        Cat cat2 = new Cat();
        cat2.setName("N1");
        cat2.setColorType(ColorType.BLUE);
        cat2.setAge(2);
        em.persist(cat2);

        em.getTransaction().commit();
    }

    private static void carProcessor(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Car car = new Car();
        car.setName("C1");
        Engine engine = new Engine();
        engine.setVolume(2.0f);
        engine.setEngineName("Eng1");
        car.setEngine(engine);
        em.persist(car);

        em.getTransaction().commit();
    }


    private static void computerProcessor(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        ComputerKey key = new ComputerKey();
        key.setPrice(1);
        key.setTitle("T1");

        Computer computer = new Computer();
        computer.setManufactor("M1");
        computer.setComputerKey(key);

        em.persist(computer);

        em.getTransaction().commit();
    }

    private static void mergeDogExample(){
        dogProcessor();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Dog dog1 = new Dog();
        dog1.setName("MyDog1");
        dog1.setColorType(ColorType.RED);
        em.persist(dog1);

        Dog dog2 = new Dog();
        dog2.setId(11);
        dog2.setName("UPDATEDOG");
        em.persist(dog2);

        Dog d=em.find(Dog.class, 1);
        System.out.println(d);
        d.setColorType(ColorType.BLUE);
        em.merge(d);

        em.remove(d);

        em.getTransaction().commit();
    }

    private static void findCompositePKComputerExample(){
        computerProcessor();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        ComputerKey key = new ComputerKey();
        key.setPrice(1);
        key.setTitle("T1");

        Computer computer = em.find(Computer.class, key);
        System.out.println(computer);

        em.getTransaction().commit();
    }



    private static void listenerAnimalExample(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Animal animal = new Animal();
        animal.setName("A1");
        animal.setAge(1);

        em.persist(animal);

        em.getTransaction().commit();

        em.getTransaction().begin();

        Animal a=em.find(Animal.class,1);

        em.remove(a);
        em.getTransaction().commit();



    }









}
