package com.app;

/**
 * Created by denys on 6/20/2017.
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DAOImpl();
        Animal a = new Animal();
        a.setName("A");
        a.setAge(1);
        dao.saveAnimal(a);
    }

}
