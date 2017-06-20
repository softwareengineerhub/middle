package com.app;

import com.app.dao.DAO;
import com.app.dao.impl.JDBCDAOImpl;
import com.app.dao.impl.JPADAOImpl;
import com.app.model.Animal;

/**
 * Created by denys on 6/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        //DAO dao = new JDBCDAOImpl();
        DAO dao = new JPADAOImpl();
        Animal a = new Animal();
        a.setName("A");
        a.setAge(1);
        dao.saveAnimal(a);
    }

}
