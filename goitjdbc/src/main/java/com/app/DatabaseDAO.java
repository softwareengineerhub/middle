package com.app;

//import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by denys on 5/23/2017.
 */
public class DatabaseDAO implements DAO {

    /*
    1. DRIVER.JAR in classpath
    2. Register Driver in programm
    3. USE java.sql.*
     */

   /* static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static{
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


   /*

   CREATE - INSERT into persons(name, age) values('Test', 25);


    */


    public void create(Person p) {
        Connection con = null;
        try{
            con = getConnection();
            Statement statement = con.createStatement();
            String sql = "INSERT into person(name, age) VALUES('"+p.getName()+"', "+p.getAge()+")";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public Person read(int id) {
        try(Connection con = getConnection()){
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM person WHERE ID="+id;
            ResultSet rs=statement.executeQuery(sql);
            Person person = new Person();
            while(rs.next()){
                String personName = rs.getString("name");
                int personAge = rs.getInt("age");
                person.setAge(personAge);
                person.setName(personName);
            }
            return person;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Person update(int id, Person person) {
        try(Connection con = getConnection()){
            Person oldPerson = read(id);
            PreparedStatement ps = con.prepareStatement("UPDATE person set name=?, age=? WHERE id=?");
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setInt(3, id);
            ps.execute();
            return oldPerson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {
        try(Connection con = getConnection()){
            Statement statement = con.createStatement();
            statement.execute("DELETE FROM person WHERE id="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    {
        Connection con=null;
        //Oracle - пакет
        //процедуры и фУНКЦИИ
        //процедуры - это не void методы
        //функции - это методы с void
        //CallableStatement cb = con.prepareCall("");
        //cb.registerOutParameter();

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person","root","111111");
    }

}
