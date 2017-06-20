package qqq;

//import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by denys on 6/8/2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Main main = new Main();
        main.createDatabase();
    }

    static {
        try {
           // DriverManager.registerDriver(new Driver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("CREATE DATABASE if not EXISTS qqqqqqq");
            ps.execute();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root","111111");
    }
}
