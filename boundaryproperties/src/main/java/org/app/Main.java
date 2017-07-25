package org.app;

import javax.management.Query;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by denys on 7/25/2017.
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Person person = new Person();
        int res=person.calculate(1,2);
        System.out.println("res="+res);
        Method[] method = person.getClass().getDeclaredMethods();
        for(Method m: method){
            //System.out.println(m);
            Annotation[] annotations = m.getAnnotations();
            for(Annotation annotation: annotations){
                if(annotation instanceof NeedPrint){
                    NeedPrint needPrint = (NeedPrint) annotation;
                    boolean needToPrint = needPrint.needToPrint();
                    if(needToPrint){
                        System.out.println("Printing to LOG");
                    }
                }
            }
        }



    }
}
