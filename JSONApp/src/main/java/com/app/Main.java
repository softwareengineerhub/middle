package com.app;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        Transformer transformer = getTransformer(1);
        Object t = new String();
        List<Person> persons = new ArrayList<Person>();
        init(3, persons);

        String res=transformer.from(persons);
        System.out.println(res);
        List<Person> personList=transformer.to(res);
        System.out.println(personList.size());
        for(Person p: personList){
            System.out.println(p);
        }
    }


    private static void init(int n, List<Person> list){
        for(int i=0;i<n;i++){
            Person p = new Person();
            p.setAge(i);
            p.setName("Name"+i);
            list.add(p);
        }
    }

    public static Transformer getTransformer(int type){
        switch(type){
            case 0:
                return new JSONTransformerImpl();
            case 1:
                return new XMLTransformerImpl();
            default: throw  new RuntimeException("Incorrect type="+type);
        }
    }
}
