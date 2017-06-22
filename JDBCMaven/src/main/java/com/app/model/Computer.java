package com.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by denys on 6/22/2017.
 */
@Entity
public class Computer {
    @EmbeddedId
    private ComputerKey computerKey;
    private String manufactor;

    public ComputerKey getComputerKey() {
        return computerKey;
    }

    public void setComputerKey(ComputerKey computerKey) {
        this.computerKey = computerKey;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerKey=" + computerKey +
                ", manufactor='" + manufactor + '\'' +
                '}';
    }
}
