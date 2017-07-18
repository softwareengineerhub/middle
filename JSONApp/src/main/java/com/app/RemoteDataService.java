package com.app;

/**
 * Created by Администратор on 09.07.2017.
 */
public interface RemoteDataService {

    public String getDataAsJSON(int age);

    public String getDataAsXML(int age);

    public void putDataFromJSON(String json);

    public void putDataFromXML(String xml);

}
