
package com.mycompany.test1_server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSInterface", targetNamespace = "http://test1_server.mycompany.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.test1_server.Event
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEvent", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetEvent")
    @ResponseWrapper(localName = "getEventResponse", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetEventResponse")
    public Event getEvent(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEvents", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetEvents")
    @ResponseWrapper(localName = "getEventsResponse", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetEventsResponse")
    public String getEvents();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.test1_server.Manager
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getManager", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetManager")
    @ResponseWrapper(localName = "getManagerResponse", targetNamespace = "http://test1_server.mycompany.com/", className = "com.mycompany.test1_server.GetManagerResponse")
    public Manager getManager(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

}