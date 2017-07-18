package com.app.test;

import com.app.DataService;
import com.app.DefaultProcessorImpl;
import com.app.Processor;
import com.app.XMLProcessor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by denys on 7/18/2017.
 */
public class DataServiceTest {


    @Test
    public void makeActionDefault() throws Exception {
        String name = "com.app.DefaultProcessorImpl";
        //Default constructor
        Processor processor = (Processor) Class.forName(name).newInstance();
        Field field = processor.getClass().getDeclaredField("title");
        field.setAccessible(true);
        field.set(processor, "TestExample");

        String nameService = "com.app.DataService";
        Class cl = Class.forName(nameService);
        Constructor[] constructors = cl.getDeclaredConstructors();
        Object dataService = null;
        //1 constructor
        for(Constructor c: constructors){
            dataService = c.newInstance(processor);
        }
        Method[] methods = dataService.getClass().getMethods();
        for(Method m:methods){
            if("makeAction".equals(m.getName())){
                //dataService.makeAction();
                m.invoke(dataService);
            }
        }
    }

    @Test
    public void makeActionXml(){
        Processor processor = getProcessor(1);
        DataService dataService = new DataService(processor);
        dataService.makeAction();
    }

    private Processor getProcessor(int type){
        switch(type){
            case 0:
                return new DefaultProcessorImpl("Test");
            case 1:
                return new XMLProcessor();
            default: throw new RuntimeException("Incorrect type "+type);
        }
    }
}
