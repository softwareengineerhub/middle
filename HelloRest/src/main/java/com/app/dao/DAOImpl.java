package com.app.dao;

import com.app.model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by denys on 6/29/2017.
 */
public class DAOImpl implements DAO {
    private Set<Person> data = new HashSet();

    @Override
    public void save(Person p) {
        data.add(p);
    }

    @Override
    public void update(Person oldPerson, Person newPerson) {
        for(Person p: data){
            if(p.getName().equals(oldPerson.getName())){
                if(p.getAge()==oldPerson.getAge()){
                    p.setAge(newPerson.getAge());
                    p.setName(newPerson.getName());
                    return;
                }
            }
        }
    }

    @Override
    public void delete(Person p) {
        data.remove(p);
    }

    @Override
    public List<Person> getByName(String name) {
        List<Person> persons = new ArrayList();
        for(Person p: data){
            if(p.getName().equals(name)){
                persons.add(p);
            }
        }
        return persons;
    }

    @Override
    public List<Person> getByAge(int age) {
        List<Person> persons = new ArrayList();
        for(Person p: data){
            if(p.getAge()==age){
                persons.add(p);
            }
        }
        return persons;
    }
}
