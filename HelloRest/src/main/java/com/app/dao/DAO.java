package com.app.dao;

import com.app.model.Person;

import java.util.List;

/**
 * Created by denys on 6/29/2017.
 */
public interface DAO {

    public void save(Person p);

    public void update(Person oldPerson, Person newPerson);

    public void delete(Person p);

    public List<Person> getByName(String name);

    public List<Person> getByAge(int age);
}
