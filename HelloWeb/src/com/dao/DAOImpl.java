package com.dao;

import com.app.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by denys on 6/13/2017.
 */
public class DAOImpl implements DAO {


    @Override
    public void save(Person person) {
        try {
            try(Connection c = getConnection()){
                PreparedStatement ps = c.prepareStatement("Insert into hello.persons(name, age) values(?,?)");
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
                ps.execute();            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hello?useSSL=false","root","111111");
    }
}
