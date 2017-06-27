package com.calc;

import javax.xml.ws.Endpoint;

/**
 * Created by denys on 6/27/2017.
 */
public class SoapMain {

    public static void main(String[] args) {
        //http://127.0.0.1:8084/calc?wsdl
        Endpoint.publish("http://127.0.0.1:8084/calc", new CalculatorImpl());
    }

}
