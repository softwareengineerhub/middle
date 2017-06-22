package com.app.model;

import javax.persistence.Embeddable;

/**
 * Created by denys on 6/22/2017.
 */
@Embeddable
public class Engine {
    private String engineName;
    private float volume;

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}
