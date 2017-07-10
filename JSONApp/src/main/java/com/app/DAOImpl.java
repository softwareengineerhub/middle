package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public class DAOImpl implements DAO {
    private List<Person> persons = new ArrayList<Person>();

    public DAOImpl() {
        for(int i=0;i<10;i++){
            Person p = new Person();
            p.setAge(i);
            p.setName("Name"+i);
            persons.add(p);
        }
    }

    public List<Person> getByAge(int age) {
        List<Person> res = new ArrayList();
        for(Person p: persons){
            if(p.getAge()==age){
                res.add(p);
            }
        }
        return res;
    }

    public void save(List<Person> persons) {
        this.persons.addAll(persons);
    }
}
