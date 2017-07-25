package org.app;

/**
 * Created by denys on 7/25/2017.
 */
public class Person {

    @NeedPrint(needToPrint = true)
    public int calculate(int a, int b){
        return a+b;
    }
}
