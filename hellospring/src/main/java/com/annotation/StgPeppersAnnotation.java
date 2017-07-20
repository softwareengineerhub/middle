/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotation;

import org.springframework.stereotype.Component;

/**
 *
 * @author denys
 */
@Component("stgPeppers")
public class StgPeppersAnnotation implements CompactDisk {

    private String title = "The Title";
    private String artist = "The Annotation";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
