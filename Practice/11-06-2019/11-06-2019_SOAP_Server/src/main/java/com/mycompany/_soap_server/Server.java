/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author studente
 */
public class Server {
    public static void main(String args[]) {
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:8080/Exam-2019-06-11_SOAPWS/ProfessorManagement";
        Endpoint.publish(address, implementor);
        
        System.out.println("Server started...");
        
        while(true) {}
    }
    
}
