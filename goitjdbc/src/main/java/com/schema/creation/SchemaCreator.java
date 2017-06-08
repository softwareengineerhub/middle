package com.schema.creation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by denys on 6/8/2017.
 */
public class SchemaCreator {

    public void createSchema(String databaseName) throws SQLException {
        try(Connection c = getConnection()){
            c.prepareStatement("CREATE SCHEMA IF NOT EXISTS "+databaseName).execute();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/","root","111111");
    }
}
