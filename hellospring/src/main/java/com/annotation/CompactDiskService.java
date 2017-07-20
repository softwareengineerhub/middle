package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by denys on 7/20/2017.
 */
@Service
public class CompactDiskService {
    //@Autowired

    //@Resource(name = "stgPeppers")

    /*@Autowired
    //@Qualifier("dvd")
    @Qualifier("stgPeppers")*/

    @Resource(name = "stgPeppers")
    private CompactDisk compactDisk;

    public void makeServiceAction(){
        System.out.println("Before compactDisk call");
        compactDisk.play();
        System.out.println("After compactDisk call");
    }
}
