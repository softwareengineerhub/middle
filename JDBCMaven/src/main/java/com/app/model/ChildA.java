package com.app.model;

import javax.persistence.Entity;

/**
 * Created by denys on 6/22/2017.
 */
@Entity
public class ChildA extends Parent {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
