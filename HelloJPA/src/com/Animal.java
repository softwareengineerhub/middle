package com;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by denys on 6/15/2017.
 */
@Entity
public class Animal {
    @Id
    private int age;
    @Id
    private String name;

    private String nameOfAnimal;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }
}
