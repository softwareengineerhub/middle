package com.app.model;

import javax.persistence.*;


/**
 * Created by denys on 6/22/2017.
 */

public class AnimalListener {

    @PrePersist
    public void prePersist(Object o){
        System.out.println("PrePersist"+o);
        if(o.getClass()==Animal.class) {
            Animal a = (Animal) o;
            a.setName("Test");
        }
    }

    @PostPersist
    public void postPersist(Object o){
        if(o.getClass()==Animal.class){

        }else if(o.getClass()==Cat.class){

        }
        System.out.println("PostPersist");
    }

    @PreRemove
    public void preRemove(Object o){
        System.out.println("PreRemove");
    }

    @PostRemove
    public void postRemove(Object o){
        System.out.println("PostRemove");
    }

    @PostLoad
    public void postLoad(Object o){
        System.out.println("PostRemove");
    }


}
