/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.calc.CalculatorImpl;
import com.calc.CalculatorImplService;

/**
 *
 * @author denys
 */
public class Helper {
    
    public int calculate(int a, int b){
        CalculatorImplService implService = new CalculatorImplService();
        CalculatorImpl calculatorImpl =  implService.getCalculatorImplPort();
        return calculatorImpl.add(a, b);
    }
    
    public static void main(String[] args){
        Helper h = new Helper();
        int res=h.calculate(11, 21);
        System.out.println("res="+res);
    }
    
}
