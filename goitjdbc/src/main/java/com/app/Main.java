package com.app;

import javax.swing.*;
import java.io.*;

/**
 * Created by denys on 5/23/2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

//        "Denis" --> 1

  //      "Usern"-->"n"

        //name, age, role
        //"Denis", "30", "role1"
        //"Boris", "26", "role2"
        //"Piter", "45", "role3"
        // .........
        //"Usern", "m", "role_n"




        DAO dao = new DatabaseDAO();

        Person person = new Person();
        person.setAge(30);
        person.setName("Denis");
        System.out.println("----CREATE-----");

        try {
            dao.create(person);
        }catch(Exception ex){
            //PrintStream old = System.out;

            //System.setErr(new PrintStream(new FileOutputStream(new File("C:\\Users\\denys\\Documents\\dumps\\error.txt"))));
            //ex.printStackTrace();

            ByteArrayOutputStream buff = new ByteArrayOutputStream();
            System.setErr(new PrintStream(buff));
            ex.printStackTrace();
            byte[] data=buff.toByteArray();
            String error  = new String(data);

            JOptionPane.showMessageDialog(null, error);
        }

/*
        Person readPerson=dao.read(1);
        System.out.println("----READ-----");
        System.out.println(readPerson);

        Person personUpdated = new Person();
        personUpdated.setName("Boris");
        personUpdated.setAge(45);
        Person oldPerson = dao.update(1, personUpdated);
        System.out.println("----UPDATE-----");
        System.out.println("----old person:-----");
        System.out.println(oldPerson);
        System.out.println("----current person:-----");
        Person currentPerson=dao.read(1);
        System.out.println(currentPerson);

        System.out.println("----DELETE-----");
        dao.delete(1);
       // System.out.println("----current person:-----");
       // Person currentPersonAfterDelete=dao.read(1);
       // System.out.println(currentPersonAfterDelete);\
       */
    }
}
