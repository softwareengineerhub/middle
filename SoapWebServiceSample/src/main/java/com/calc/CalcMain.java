package com.calc;

/**
 * Created by denys on 6/27/2017.
 */
public class CalcMain {

    public static void main(String[] args) {
        //-ea
        //assert false : "Message";
        Calculator calculator = new CalculatorImpl();
        int res=calculator.add(1,2);
        System.out.println(res);
    }
}
