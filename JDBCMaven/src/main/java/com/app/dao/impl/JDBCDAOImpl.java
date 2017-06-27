package com.app.dao.impl;

import com.app.dao.DAO;
import com.app.model.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by denys on 6/20/2017.
 */
public class JDBCDAOImpl implements DAO {


    public void saveAnimal(Animal animal) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO dao_db.animal(name, age) VALUES(?,?)");
            ps.setInt(2, animal.getAge());
            ps.setString(1, animal.getName());
            ps.ex
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dao_db","root","111111");
    }
}
