package com.app;

/**
 * Created by denys on 7/18/2017.
 */
public class DefaultProcessorImpl implements Processor{
    private String title;


    public DefaultProcessorImpl(String title) {
        this.title = title;
    }

    public DefaultProcessorImpl() {
    }

    public void process() {
        System.out.println("Default processor."+title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
