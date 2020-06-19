package com.mycompany.test2_server;


import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class Server {
    private static String BASE_URL = "http://localhost:8080";
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        
        factoryBean.setResourceClasses(FlightsRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new FlightsRepository()));
        factoryBean.setAddress(BASE_URL);
        
        org.apache.cxf.endpoint.Server server = factoryBean.create();
        
        server.start();
        
        System.out.println("Server started");
        
        while(true) {}
    }
    
}
