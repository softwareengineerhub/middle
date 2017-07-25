package com.app;

/**
 * Created by denys on 7/25/2017.
 */
public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        MyListener1 listener1 = new MyListener1();
        customer.addListener(listener1);

        MyListener1 listener2 = new MyListener1();
        customer.addListener(listener2);

        customer.setName("C1");
        System.out.println("-------------------");
        customer.setAge(1);


    }
}
