package com.calc;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by denys on 6/27/2017.
 */
@WebService
public class CalculatorImpl implements Calculator {

    @WebMethod
    public int add(int a, int b) {
        System.out.println("Here. a="+a+"; b="+b);
       /* try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return a+b;
    }
}
