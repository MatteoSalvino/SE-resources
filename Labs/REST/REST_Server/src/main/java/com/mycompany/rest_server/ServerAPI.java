/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class ServerAPI {
    private static final String BASE_URL = "http://localhost:8080";
    
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        
        factoryBean.setResourceClasses(CoursesRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new CoursesRepository()));
        factoryBean.setAddress(BASE_URL);
        
        Server server = factoryBean.create();
        
        server.start();
        
        System.out.println("Server started");
        
        while(true) {}
    }
}
