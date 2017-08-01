package com.app;

import java.util.List;

/**
 * Created by denys on 8/1/2017.
 */
public interface PersonDao {

    public String getNameById(int id);

    public int getAgeById(int id);

    public List<Person> getAll();

}
