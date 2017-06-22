package com.app.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by denys on 6/22/2017.
 */
@Embeddable
public class ComputerKey implements Serializable {
    private String title;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
