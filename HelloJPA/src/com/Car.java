package com;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by denys on 6/15/2017.
 */
@Entity
public class Car {
    @EmbeddedId
    private CarId carId;

    private String manufacture;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public CarId getCarId() {
        return carId;
    }

    public void setCarId(CarId carId) {
        this.carId = carId;
    }
}
