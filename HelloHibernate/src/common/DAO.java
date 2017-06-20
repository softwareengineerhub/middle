package common;

import com.app.Person;

import java.util.List;

/**
 * Created by denys on 6/20/2017.
 */
public interface DAO {

    public void savePerson(Person person);

    public List<Person> readPersons();

}
