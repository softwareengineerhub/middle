package com.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by denys on 7/20/2017.
 */
@Component("dvd")
public class DVDDisk implements CompactDisk{

    @Override
    public void play() {
        System.out.println("DVD disk");
    }
}
