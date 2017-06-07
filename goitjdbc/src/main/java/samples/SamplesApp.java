package samples;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 6/6/2017.
 */
public class SamplesApp {

    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        SamplesApp app = new SamplesApp();
        List<Person> persons=app.getAllPersons();
        for(Person person:persons){
            System.out.println(person);
        }
        System.out.println("----------------");
        int count=app.getAllPersonsCount();
        System.out.println("count="+count);
        System.out.println("min age="+app.getMinAge());
        System.out.println("max age="+app.getMaxAge());
        System.out.println("-----MetaData-----------");
        app.showMeta();
        System.out.println("-----Bulk Insert-----------");
        System.out.println("count Before bulk insert="+app.getAllPersonsCount());
        long start = System.currentTimeMillis();
        List<Person> personsData = app.initPersosnData(10000);
        /*for(Person person:personsData){
           // long itemStart = System.currentTimeMillis();
            app.insert(person);
           // long itemTimeSpend = System.currentTimeMillis()-itemStart;
           // System.out.println("!!!itemTimeSpend="+itemTimeSpend);
        }
        long timeSpend = System.currentTimeMillis()-start;
        System.out.println("!!!timeSpend="+timeSpend);
        27580 milliseconds
        System.out.println("count After bulk insert="+app.getAllPersonsCount());*/

        /*app.bulkInsert(personsData);
        long timeSpend = System.currentTimeMillis()-start;
        //1591
        System.out.println("!!!timeSpend="+timeSpend);
        System.out.println("count After bulk insert="+app.getAllPersonsCount());*/


        app.bulkInsertWithBatch(personsData);
        long timeSpend = System.currentTimeMillis()-start;
        //990
        System.out.println("!!!timeSpend="+timeSpend);
        System.out.println("count After bulk insert="+app.getAllPersonsCount());
        //PERSON - COMPLEXTyep
        //ARRAyComplexType
        //id, name, age
    }


    public void bulkInsert(List<Person> persons) throws SQLException {
        try(Connection c = getConnection()){
            c.setAutoCommit(false);
            for(Person person: persons) {
                PreparedStatement ps = c.prepareStatement("INSERT INTO samples.persons (name, age) VALUES(?,?)");
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
                ps.execute();
            }
            c.commit();
        }
    }

    public void bulkInsertWithBatch(List<Person> persons) throws SQLException {
        try(Connection c = getConnection()){
            //c.setAutoCommit(false);
            for(Person person: persons) {
                PreparedStatement ps = c.prepareStatement("INSERT INTO samples.persons (name, age) VALUES(?,?)");
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
                ps.executeBatch();
            }
            //c.commit();
        }
    }

    public void insert(Person person) throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO samples.persons (name, age) VALUES(?,?)");
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.execute();
        }
    }

    private List<Person> initPersosnData(int limit){
        List<Person> persons = new ArrayList<>();
        for(int i=0;i<limit;i++){
            Person p = new Person();
            p.setAge(i);
            p.setName("Name"+i);
            persons.add(p);
        }
        return persons;
    }






    public void showMeta() throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * FROM samples.persons");
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("ColumnCount="+columnCount);
            String columnName1=metaData.getColumnName(1);
            System.out.println("ColumnName[1]="+columnName1);
            String columnName2=metaData.getColumnName(2);
            System.out.println("ColumnName[2]="+columnName2);
            String columnName3=metaData.getColumnName(3);
            System.out.println("ColumnName[3]="+columnName3);
            System.out.println("----FOR loop-----");
            String[] columns = new String[columnCount];
            String[] columnsType = new String[columnCount];
            for(int i=0;i<columnCount;i++){
                String columnName = metaData.getColumnName(i+1);
                columns[i] = columnName;
                columnsType[i] = metaData.getColumnClassName(i+1);
                System.out.println(String.format("ColumnName[%s]=%s",i+1, columnName));
                System.out.println(String.format("ColumnType[%s]=%s",i+1, columnsType[i] ));
            }
            while(rs.next()){
                System.out.println();
                /*for(String columnNameItem: columns){
                    Object value = rs.getObject(columnNameItem);
                }*/
                for(int i=0;i<columns.length;i++){
                    String type=columnsType[i];
                    String columnNameItem = columns[i];
                    if("java.lang.Integer".equals(type)){
                        int val=rs.getInt(columnNameItem);
                        System.out.println(columnNameItem+"="+val);
                    } else if("java.lang.String".equals(type)){
                        String val=rs.getString(columnNameItem);
                        System.out.println(columnNameItem+"="+val);
                    }
                }
            }

        }
    }
















    public int getAllPersonsCount() throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT count(*) as amount FROM SAMPLES.persons");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public int getMaxAge() throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT max(age) FROM SAMPLES.persons");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public int getMinAge() throws SQLException {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT MIN(age) FROM SAMPLES.persons");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList();
         try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * FROM SAMPLES.persons");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int age=rs.getInt("age");
                String name = rs.getString("name");
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                persons.add(person);
            }
         }
         return persons;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/samples?useSSL=false","root","111111");
    }

}
