package com.app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by denys on 7/25/2017.
 */
public class MyListener1 implements PropertyChangeListener {

    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName=evt.getPropertyName();
        System.out.println("propertyName="+propertyName);
        System.out.println("source="+evt.getSource());
        System.out.println("oldValue="+evt.getOldValue());
        System.out.println("newValue="+evt.getNewValue());
    }
}
