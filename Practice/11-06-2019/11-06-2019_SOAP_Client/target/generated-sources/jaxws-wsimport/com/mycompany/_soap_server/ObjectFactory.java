
package com.mycompany._soap_server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany._soap_server package. 
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

    private final static QName _GetDetailsResponse_QNAME = new QName("http://_soap_server.mycompany.com/", "getDetailsResponse");
    private final static QName _GetDetails_QNAME = new QName("http://_soap_server.mycompany.com/", "getDetails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany._soap_server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDetailsResponse }
     * 
     */
    public GetDetailsResponse createGetDetailsResponse() {
        return new GetDetailsResponse();
    }

    /**
     * Create an instance of {@link GetDetails }
     * 
     */
    public GetDetails createGetDetails() {
        return new GetDetails();
    }

    /**
     * Create an instance of {@link Professor }
     * 
     */
    public Professor createProfessor() {
        return new Professor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://_soap_server.mycompany.com/", name = "getDetailsResponse")
    public JAXBElement<GetDetailsResponse> createGetDetailsResponse(GetDetailsResponse value) {
        return new JAXBElement<GetDetailsResponse>(_GetDetailsResponse_QNAME, GetDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://_soap_server.mycompany.com/", name = "getDetails")
    public JAXBElement<GetDetails> createGetDetails(GetDetails value) {
        return new JAXBElement<GetDetails>(_GetDetails_QNAME, GetDetails.class, null, value);
    }

}
