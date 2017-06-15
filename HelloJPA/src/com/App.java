package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by denys on 6/15/2017.
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        DAO dao = new DAOImpl(em);
        Person p = new Person();
        p.setAge(11);
        p.setName("Aaaa");
        em.persist(p);


        Person p1=em.find(Person.class, 1);
        System.out.println(p1);

        Employee emp = new Employee();
        emp.setName("Employee");
        emp.setAge(22);
        emp.setEmployeeType(EmployeeType.A);

        Department department = new Department();
        department.setTitle("T1");
        department.setYear(1234);

        Animal animal = new Animal();
        animal.setName("A");
        animal.setAge(1);
        animal.setNameOfAnimal("NameA");
        em.persist(animal);

        /*Animal animal1 = new Animal();
        animal1.setName("A");
        animal1.setAge(1);
        animal1.setNameOfAnimal("NameB");*/


        Car car = new Car();
        car.setManufacture("A");
        CarId carId = new CarId();
        carId.setAge(10);
        carId.setModel("M1");

        em.persist(car);


        em.persist(emp);

        em.getTransaction().commit();
    }


}
