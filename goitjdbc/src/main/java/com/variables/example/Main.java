package com.variables.example;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * Created by denys on 6/8/2017.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> env=System.getenv();
        for(String key: env.keySet()){
            System.out.println(key+"="+env.get(key));
        }

        System.out.println("---------------------------------");
        //java -jar MyApp.jar -Dkey=value -Dkey1=value1
        Properties props=System.getProperties();
        for(Object key: props.keySet()){
            System.out.println(key+"="+env.get(key));
        }

    }
}
