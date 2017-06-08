package com.blob.example;

/**
 * Created by denys on 6/8/2017.
 */
public class Record {
    private String name;
    private byte[] dataContent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getDataContent() {
        return dataContent;
    }

    public void setDataContent(byte[] dataContent) {
        this.dataContent = dataContent;
    }
}
