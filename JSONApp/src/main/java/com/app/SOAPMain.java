package com.app;

import javax.xml.ws.Endpoint;

/**
 * Created by Администратор on 09.07.2017.
 */
public class SOAPMain {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8081/myservice", new SOAPEndpoint());
    }
}
