/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._jms_server;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author studente
 */
public class Publisher {
    Properties properties;
    InitialContext jndiContext;
    TopicConnectionFactory cf;
    TopicConnection connection;
    TopicSession session;
    Topic destination;
    String destinationName;
    TopicPublisher publisher;
    

    public Publisher(String _destinationName) {
        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            
            this.jndiContext = new InitialContext(properties);
            this.cf = (TopicConnectionFactory) jndiContext.lookup("ConnectionFactory");
            this.connection = cf.createTopicConnection();
            this.session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            this.destinationName = _destinationName;
            this.destination = (Topic) jndiContext.lookup(destinationName);
            this.publisher = session.createPublisher(destination);
        } catch (NamingException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void start() {
        try {
            this.connection.start();
            System.out.println("Server started....");
            
            while(true) {
                System.out.println("Publishing message...");
                sendMessage();
                
                try {
                    Thread.sleep(3000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(this.connection != null) {
                try {
                    this.connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void stop() throws JMSException {
        this.connection.stop();
    }

    private void sendMessage() {
        try {
            TextMessage message = session.createTextMessage();
           
            message.setStringProperty("id", String.valueOf((int)(Math.random() * 3)));
            message.setFloatProperty("ranking", (float) Math.random() * 100);
            publisher.publish(message);
            System.out.println("Message (" + message.getStringProperty("id") +", " + message.getFloatProperty("ranking") + ") published");
        } catch (JMSException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
