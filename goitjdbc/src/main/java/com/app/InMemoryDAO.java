package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 5/23/2017.
 */
public class InMemoryDAO implements DAO {
    private List<Person> data = new ArrayList();

    public void create(Person p) {
        data.add(p);
    }

    public Person read(int id) {
        return data.get(id-1);
    }

    public Person update(int id, Person person) {
        return data.set(id-1, person);
    }

    public void delete(int id) {
        data.remove(id-1);
    }
}
