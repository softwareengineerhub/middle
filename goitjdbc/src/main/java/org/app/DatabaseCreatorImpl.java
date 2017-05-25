package org.app;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by denys on 5/25/2017.
 *
 * /*
 1. DRIVER.JAR in classpath (maven dependency)
 2. Register Driver in programm  (Class for name or  DriverManger.registerDriver)
 3. USE java.sql.*
 */
public class DatabaseCreatorImpl implements DatabaseCreator {

    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createSchema() {
        /*

         */
    }

    @Override
    public void createTable() {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/app_db", "root", "111111");
    }



}
