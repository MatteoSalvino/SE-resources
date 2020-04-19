/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXB;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/**
 *
 * @author studente
 */
public class Client {
    private static final String BASE_URL = "http://localhost:8080/courses";
    private static CloseableHttpClient client;
    
    public static void main(String[] args) throws IOException {
        client = HttpClients.createDefault();
        
        //GET requests
        Course c1 = getCourse(1);
        System.out.println(c1);
        
        for(int i = 0; i < c1.getStudents().size(); i++) {
            System.out.println(c1.getStudents().get(i));
        }
        
        Student s1 = getStudent(1, 1);
        System.out.println(s1);
        
        //POST request
        Course c2 = getCourse(2);
        System.out.println(c2);
        
        System.out.println("Post request performed");
        createValidStudent();
        
        
        c2 = getCourse(2);
        System.out.println(c2);

        if(c2.getStudents() != null) {
            for(int i = 0; i < c2.getStudents().size(); i++) {
                System.out.println(c2.getStudents().get(i));
            } 
        }
        
        client.close();
    }
    
    private static Course getCourse(int courseID) throws MalformedURLException, IOException {
        URL url = new URL(BASE_URL + "/" + courseID);
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Course.class);   
    }
    
    private static Student getStudent(int courseID, int studentID) throws MalformedURLException, IOException {
        URL url = new URL(BASE_URL + "/" + courseID + "/students/" + studentID);
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Student.class);   
    }
    
    private static void createValidStudent() throws IOException {
        final HttpPost httpPost = new HttpPost(BASE_URL + "/2/students");
        final InputStream resourceStream = Client.class.getClassLoader().getResourceAsStream("newStudent.xml");
        
        httpPost.setEntity(new InputStreamEntity(resourceStream));
        httpPost.setHeader("Content-Type", "text/xml");
        
        final HttpResponse response = client.execute(httpPost);
        System.out.println(response.toString());
    }
 
}
