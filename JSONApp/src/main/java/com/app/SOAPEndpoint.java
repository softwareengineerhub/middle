package com.app;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.lang.reflect.Field;

/**
 * Created by Администратор on 09.07.2017.
 */
@WebService
public class SOAPEndpoint implements RemoteDataService {

    private RemoteDataService remoteDataService = new RemoteDataServiceImpl();

    public SOAPEndpoint() {
        try {
            Field field = remoteDataService.getClass().getDeclaredField("dao");
            if(field.getType()==DAO.class){
                field.setAccessible(true);
                field.set(remoteDataService, new DAOImpl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    public String getDataAsJSON(int age) {
        return remoteDataService.getDataAsJSON(age);
    }

    @WebMethod
    public String getDataAsXML(int age) {
        return remoteDataService.getDataAsXML(age);
    }

    @WebMethod
    public void putDataFromJSON(String json) {
        remoteDataService.putDataFromJSON(json);
    }

    @WebMethod
    public void putDataFromXML(String xml) {
        remoteDataService.putDataFromXML(xml);
    }
}
