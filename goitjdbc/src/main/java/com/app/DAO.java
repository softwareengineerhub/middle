package com.app;

/**
 * Created by denys on 5/23/2017.
 *
 * Person
 * id name    age
 * primary key
 * 1  Piter    45
 * 2  Boris    24
 *
 */
public interface DAO {

    /*CRUD operations
    C- create
    R - read
    U  - update
    D - delete
    */


    public void create(Person p);

    public Person read(int id);

    public Person update(int id, Person person);

    public void delete(int id);
}
