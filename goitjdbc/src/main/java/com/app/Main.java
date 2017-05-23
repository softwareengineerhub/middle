package com.app;

/**
 * Created by denys on 5/23/2017.
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DatabaseDAO();

        Person person = new Person();
        person.setAge(30);
        person.setName("Denis");
        System.out.println("----CREATE-----");
        dao.create(person);


        Person readPerson=dao.read(1);
        System.out.println("----READ-----");
        System.out.println(readPerson);

        Person personUpdated = new Person();
        personUpdated.setName("Boris");
        personUpdated.setAge(45);
        Person oldPerson = dao.update(1, personUpdated);
        System.out.println("----UPDATE-----");
        System.out.println("----old person:-----");
        System.out.println(oldPerson);
        System.out.println("----current person:-----");
        Person currentPerson=dao.read(1);
        System.out.println(currentPerson);

        System.out.println("----DELETE-----");
        dao.delete(1);
       // System.out.println("----current person:-----");
       // Person currentPersonAfterDelete=dao.read(1);
       // System.out.println(currentPersonAfterDelete);
    }
}
