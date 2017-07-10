package com.app;

import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public interface DAO {

    List<Person> getByAge(int age);

    void save(List<Person> persons);
}
