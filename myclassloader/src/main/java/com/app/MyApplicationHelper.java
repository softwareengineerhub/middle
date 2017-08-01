package com.app;

/**
 * Created by denys on 8/1/2017.
 */
public class MyApplicationHelper {

    public boolean validate(String value){
        System.out.println("@Hello Validation");
        return "SUCCESS".equalsIgnoreCase(value);
    }
}
