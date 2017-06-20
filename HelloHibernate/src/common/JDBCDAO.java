package common;

import com.app.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by denys on 6/20/2017.
 */
public class JDBCDAO implements DAO {

    @Override
    public void savePerson(Person person) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("");
            ps.setInt(1, person.getAge());
            ps.setString(2, person.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readPersons() {
        return null;
    }

    private Connection getConnection() throws SQLException {
            return DriverManager.getConnection("","","");
    }
}
