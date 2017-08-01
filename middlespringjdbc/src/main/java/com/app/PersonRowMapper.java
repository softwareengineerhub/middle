package com.app;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by denys on 8/1/2017.
 */
public class PersonRowMapper implements RowMapper<Person>{

    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        return person;
    }
}
