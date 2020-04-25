/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author studente
 */
public class Client {
    private final static String BASE_URL = "http://localhost:8080/flights/";
    private static CloseableHttpClient client;
            
    public static void main(String[] args) throws MalformedURLException, IOException {
        client = HttpClients.createDefault();
        
        //GET example
        ObjectMapper mapper = new ObjectMapper();
        
        URL url = new URL(BASE_URL + "2");
        InputStream input = url.openStream();
        
        Flight flight = (Flight) mapper.readValue(input, Flight.class);
        System.out.println(flight);
        
        //PUT example
        ObjectMapper objectMapper = new ObjectMapper();
        Flight newFlight = new Flight();
        
        newFlight.setId(4);
        newFlight.setName("AZ231");
        
        String value = objectMapper.writeValueAsString(newFlight);
        
        HttpPut httpPut = new HttpPut(BASE_URL + "2/");
        StringEntity entity = new StringEntity(value);
        
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        
        HttpResponse response = client.execute(httpPut);
        
        InputStream is2 = url.openStream();
        flight = (Flight) mapper.readValue(is2, Flight.class);
        System.out.println(flight);       
        
    }
    
}
