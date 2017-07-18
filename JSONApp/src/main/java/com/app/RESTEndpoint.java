package com.app;

//import static spark.Spark.get;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.RouteImpl;

import java.lang.reflect.Field;

/**
 * Created by Администратор on 09.07.2017.
 */
public class RESTEndpoint {

    public static void main(String[] args) {
        final RemoteDataService remoteDataService = new RemoteDataServiceImpl();
        try {
            Field field = remoteDataService.getClass().getDeclaredField("dao");
            if(field.getType()==DAO.class){
                field.setAccessible(true);
                field.set(remoteDataService, new DAOImpl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        spark.Spark.get("/test", new RouteImpl("") {

            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Test";
            }
        });

        spark.Spark.get("/json", new RouteImpl(""){


            public Object handle(Request request, Response response) throws Exception {

                System.out.println("Hello");
                System.out.println(request.params());
                String ageValue=request.params("age");
                System.out.println(ageValue);
                int age = Integer.parseInt(ageValue);
               String json=remoteDataService.getDataAsJSON(age);
               return json;
            }
        });
        spark.Spark.get("/xml", new Route() {

            public Object handle(Request request, Response response) throws Exception {
                String ageValue=request.params("age");
                int age = Integer.parseInt(ageValue);
                String xml=remoteDataService.getDataAsXML(age);
                return xml;
            }
        });
    }


}
