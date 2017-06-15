package com;

import javax.persistence.Embeddable;

/**
 * Created by denys on 6/15/2017.
 */
@Embeddable
public class CarId {
    private int age;
    private String model;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
