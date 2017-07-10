
package com.app;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.app package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDataAsXMLResponse_QNAME = new QName("http://app.com/", "getDataAsXMLResponse");
    private final static QName _PutDataFromXMLResponse_QNAME = new QName("http://app.com/", "putDataFromXMLResponse");
    private final static QName _PutDataFromJSON_QNAME = new QName("http://app.com/", "putDataFromJSON");
    private final static QName _GetDataAsJSON_QNAME = new QName("http://app.com/", "getDataAsJSON");
    private final static QName _GetDataAsJSONResponse_QNAME = new QName("http://app.com/", "getDataAsJSONResponse");
    private final static QName _PutDataFromJSONResponse_QNAME = new QName("http://app.com/", "putDataFromJSONResponse");
    private final static QName _GetDataAsXML_QNAME = new QName("http://app.com/", "getDataAsXML");
    private final static QName _PutDataFromXML_QNAME = new QName("http://app.com/", "putDataFromXML");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.app
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataAsXMLResponse }
     * 
     */
    public GetDataAsXMLResponse createGetDataAsXMLResponse() {
        return new GetDataAsXMLResponse();
    }

    /**
     * Create an instance of {@link PutDataFromJSON }
     * 
     */
    public PutDataFromJSON createPutDataFromJSON() {
        return new PutDataFromJSON();
    }

    /**
     * Create an instance of {@link PutDataFromXMLResponse }
     * 
     */
    public PutDataFromXMLResponse createPutDataFromXMLResponse() {
        return new PutDataFromXMLResponse();
    }

    /**
     * Create an instance of {@link GetDataAsXML }
     * 
     */
    public GetDataAsXML createGetDataAsXML() {
        return new GetDataAsXML();
    }

    /**
     * Create an instance of {@link PutDataFromXML }
     * 
     */
    public PutDataFromXML createPutDataFromXML() {
        return new PutDataFromXML();
    }

    /**
     * Create an instance of {@link GetDataAsJSONResponse }
     * 
     */
    public GetDataAsJSONResponse createGetDataAsJSONResponse() {
        return new GetDataAsJSONResponse();
    }

    /**
     * Create an instance of {@link PutDataFromJSONResponse }
     * 
     */
    public PutDataFromJSONResponse createPutDataFromJSONResponse() {
        return new PutDataFromJSONResponse();
    }

    /**
     * Create an instance of {@link GetDataAsJSON }
     * 
     */
    public GetDataAsJSON createGetDataAsJSON() {
        return new GetDataAsJSON();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAsXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "getDataAsXMLResponse")
    public JAXBElement<GetDataAsXMLResponse> createGetDataAsXMLResponse(GetDataAsXMLResponse value) {
        return new JAXBElement<GetDataAsXMLResponse>(_GetDataAsXMLResponse_QNAME, GetDataAsXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutDataFromXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "putDataFromXMLResponse")
    public JAXBElement<PutDataFromXMLResponse> createPutDataFromXMLResponse(PutDataFromXMLResponse value) {
        return new JAXBElement<PutDataFromXMLResponse>(_PutDataFromXMLResponse_QNAME, PutDataFromXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutDataFromJSON }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "putDataFromJSON")
    public JAXBElement<PutDataFromJSON> createPutDataFromJSON(PutDataFromJSON value) {
        return new JAXBElement<PutDataFromJSON>(_PutDataFromJSON_QNAME, PutDataFromJSON.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAsJSON }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "getDataAsJSON")
    public JAXBElement<GetDataAsJSON> createGetDataAsJSON(GetDataAsJSON value) {
        return new JAXBElement<GetDataAsJSON>(_GetDataAsJSON_QNAME, GetDataAsJSON.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAsJSONResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "getDataAsJSONResponse")
    public JAXBElement<GetDataAsJSONResponse> createGetDataAsJSONResponse(GetDataAsJSONResponse value) {
        return new JAXBElement<GetDataAsJSONResponse>(_GetDataAsJSONResponse_QNAME, GetDataAsJSONResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutDataFromJSONResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "putDataFromJSONResponse")
    public JAXBElement<PutDataFromJSONResponse> createPutDataFromJSONResponse(PutDataFromJSONResponse value) {
        return new JAXBElement<PutDataFromJSONResponse>(_PutDataFromJSONResponse_QNAME, PutDataFromJSONResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataAsXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "getDataAsXML")
    public JAXBElement<GetDataAsXML> createGetDataAsXML(GetDataAsXML value) {
        return new JAXBElement<GetDataAsXML>(_GetDataAsXML_QNAME, GetDataAsXML.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutDataFromXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://app.com/", name = "putDataFromXML")
    public JAXBElement<PutDataFromXML> createPutDataFromXML(PutDataFromXML value) {
        return new JAXBElement<PutDataFromXML>(_PutDataFromXML_QNAME, PutDataFromXML.class, null, value);
    }

}
