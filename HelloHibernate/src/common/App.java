package common;

import com.app.Person;

/**
 * Created by denys on 6/20/2017.
 */
public class App {

    public static void main(String[] args) {
        //DAO dao = DAOFactory.getDAO(DAOType.JDBC);
        //DAO dao = DAOFactory.getDAO(DAOType.JPA);
        DAO dao = DAOFactory.getDAO(DAOType.HIBERNATE);
        Person person = new Person();
        person.setAge(23);
        person.setName("wwww");
        dao.savePerson(person);
    }
}
