package com.app;

/**
 * Created by denys on 7/18/2017.
 */
public class DataService {

    private Processor processor;

    public DataService(Processor processor) {
        this.processor = processor;
    }

    public void makeAction(){
        long start = System.currentTimeMillis();
        processor.process();
        long time= start - System.currentTimeMillis();
        System.out.println("time="+time);
    }
}
