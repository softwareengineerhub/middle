package com.app;

/**
 * Created by denys on 8/1/2017.
 */
public class Main {

    public static void main(String[] args) {
        MyApplicationHelper helper = new MyApplicationHelper();
        boolean res=helper.validate(null);
        System.out.println(res);
    }

}
