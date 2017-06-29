package com.app.model;

/**
 * Created by denys on 6/29/2017.
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode(){
        return age+(name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(obj.getClass()==Person.class){
            Person p = (Person) obj;
            if(p.age==age){
                if(p.getName()!=null){
                    return p.getName().equals(name);
                }
                if(name!=null){
                    return name.equals(p.getName());
                }
            }
            return false;
        }
        return false;
    }
}
