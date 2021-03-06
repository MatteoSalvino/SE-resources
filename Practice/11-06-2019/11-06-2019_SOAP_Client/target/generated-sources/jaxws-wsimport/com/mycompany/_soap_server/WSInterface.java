
package com.mycompany._soap_server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSInterface", targetNamespace = "http://_soap_server.mycompany.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany._soap_server.Professor
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDetails", targetNamespace = "http://_soap_server.mycompany.com/", className = "com.mycompany._soap_server.GetDetails")
    @ResponseWrapper(localName = "getDetailsResponse", targetNamespace = "http://_soap_server.mycompany.com/", className = "com.mycompany._soap_server.GetDetailsResponse")
    public Professor getDetails(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
