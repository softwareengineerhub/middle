package com.app.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by denys on 6/27/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Device.findAll", query = "Select d FROM Device d"),
        @NamedQuery(name = "Device.findCountAll", query = "Select count(d) FROM Device d"),
        @NamedQuery(name = "Device.findByModel", query = "Select d FROM Device d WHERE d.model= :model"),
        @NamedQuery(name = "Device.totalSum", query = "Select sum(d.price) FROM Device d")})
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String manufacture;
    private String model;
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
