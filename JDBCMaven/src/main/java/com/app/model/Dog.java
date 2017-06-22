package com.app.model;

import javax.persistence.*;

/**
 * Created by denys on 6/22/2017.
 */
@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Enumerated(EnumType.STRING)
    //@Enumerated(EnumType.ORDINAL)
    @Enumerated
    private ColorType colorType;
    private float feight;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public float getFeight() {
        return feight;
    }

    public void setFeight(float feight) {
        this.feight = feight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", colorType=" + colorType +
                ", feight=" + feight +
                '}';
    }
}
