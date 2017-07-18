package org.client;

import com.app.SOAPEndpoint;
import com.app.SOAPEndpointService;

/**
 * Created by Администратор on 09.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        SOAPEndpointService service = new SOAPEndpointService();
        SOAPEndpoint soapEndpoint = service.getSOAPEndpointPort();
        String json=soapEndpoint.getDataAsJSON(1);
        System.out.println(json);
        String xml=soapEndpoint.getDataAsXML(5);
        System.out.println(xml);
    }
}
