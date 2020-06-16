
package com.mycompany.test1_server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.test1_server package. 
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

    private final static QName _GetEventsResponse_QNAME = new QName("http://test1_server.mycompany.com/", "getEventsResponse");
    private final static QName _GetManagerResponse_QNAME = new QName("http://test1_server.mycompany.com/", "getManagerResponse");
    private final static QName _GetEventResponse_QNAME = new QName("http://test1_server.mycompany.com/", "getEventResponse");
    private final static QName _GetEvent_QNAME = new QName("http://test1_server.mycompany.com/", "getEvent");
    private final static QName _GetEvents_QNAME = new QName("http://test1_server.mycompany.com/", "getEvents");
    private final static QName _GetManager_QNAME = new QName("http://test1_server.mycompany.com/", "getManager");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.test1_server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEvent }
     * 
     */
    public GetEvent createGetEvent() {
        return new GetEvent();
    }

    /**
     * Create an instance of {@link GetEvents }
     * 
     */
    public GetEvents createGetEvents() {
        return new GetEvents();
    }

    /**
     * Create an instance of {@link GetManager }
     * 
     */
    public GetManager createGetManager() {
        return new GetManager();
    }

    /**
     * Create an instance of {@link GetManagerResponse }
     * 
     */
    public GetManagerResponse createGetManagerResponse() {
        return new GetManagerResponse();
    }

    /**
     * Create an instance of {@link GetEventResponse }
     * 
     */
    public GetEventResponse createGetEventResponse() {
        return new GetEventResponse();
    }

    /**
     * Create an instance of {@link GetEventsResponse }
     * 
     */
    public GetEventsResponse createGetEventsResponse() {
        return new GetEventsResponse();
    }

    /**
     * Create an instance of {@link Manager }
     * 
     */
    public Manager createManager() {
        return new Manager();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getEventsResponse")
    public JAXBElement<GetEventsResponse> createGetEventsResponse(GetEventsResponse value) {
        return new JAXBElement<GetEventsResponse>(_GetEventsResponse_QNAME, GetEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetManagerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getManagerResponse")
    public JAXBElement<GetManagerResponse> createGetManagerResponse(GetManagerResponse value) {
        return new JAXBElement<GetManagerResponse>(_GetManagerResponse_QNAME, GetManagerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getEventResponse")
    public JAXBElement<GetEventResponse> createGetEventResponse(GetEventResponse value) {
        return new JAXBElement<GetEventResponse>(_GetEventResponse_QNAME, GetEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getEvent")
    public JAXBElement<GetEvent> createGetEvent(GetEvent value) {
        return new JAXBElement<GetEvent>(_GetEvent_QNAME, GetEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEvents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getEvents")
    public JAXBElement<GetEvents> createGetEvents(GetEvents value) {
        return new JAXBElement<GetEvents>(_GetEvents_QNAME, GetEvents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetManager }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test1_server.mycompany.com/", name = "getManager")
    public JAXBElement<GetManager> createGetManager(GetManager value) {
        return new JAXBElement<GetManager>(_GetManager_QNAME, GetManager.class, null, value);
    }

}
