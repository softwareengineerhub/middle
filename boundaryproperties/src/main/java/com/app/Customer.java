package com.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by denys on 7/25/2017.
 */
public class Customer {
    private String name;
    private int age;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        support.firePropertyChange("name", this.name, name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        support.firePropertyChange("age", this.age, age);
        this.age = age;
    }

    public void addListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}
