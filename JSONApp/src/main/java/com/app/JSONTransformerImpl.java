package com.app;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public class JSONTransformerImpl implements Transformer {

    public String from(List<Person> persons) {
        JSONObject root = new JSONObject();
        JSONArray array = new JSONArray();
        for(Person person: persons){
            JSONObject item = new JSONObject();
            item.put("name", person.getName());
            item.put("age", person.getAge());
            array.put(item);
        }
        root.put("persons", array);
        return root.toString();
    }

    public List<Person> to(String str) {
        List<Person> persons = new ArrayList<Person>();
        JSONObject obj = new JSONObject(str);
        JSONArray array = obj.getJSONArray("persons");
        for(int i=0;i<array.length();i++){
            JSONObject item = array.getJSONObject(i);
            Person p = new Person();
            p.setName(item.getString("name"));
            p.setAge(item.getInt("age"));
            persons.add(p);
        }
        return persons;
    }
}
