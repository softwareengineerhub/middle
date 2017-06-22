package com.app.model;

import javax.persistence.Entity;

/**
 * Created by denys on 6/22/2017.
 */
@Entity
public class Child extends Parent{
    private String secondName;

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
