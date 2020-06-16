/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_client;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author studente
 */
public class ProfessorListener implements MessageListener {
    Properties properties;
    InitialContext jndiContext;
    TopicConnectionFactory cf;
    TopicConnection connection;
    TopicSession session;
    Topic destination;
    String destinationName;
    TopicSubscriber subscriber;
    

    public ProfessorListener(String _destinationName) {
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
            this.subscriber = session.createSubscriber(destination);
            this.subscriber.setMessageListener(this);
        } catch (NamingException ex) {
            Logger.getLogger(ProfessorListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(ProfessorListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void start() throws JMSException {
        this.connection.start();
    }
    
    public void stop() throws JMSException {
        this.connection.stop();
    }

    @Override
    public void onMessage(Message msg) {
        TextMessage message = null;
        try {
            if(msg instanceof TextMessage) {
                message = (TextMessage) msg;
                String id = message.getStringProperty("id");
                Float ranking = message.getFloatProperty("ranking");
                
                com.mycompany._soap_server.WSImplService service = new com.mycompany._soap_server.WSImplService();
                com.mycompany._soap_server.WSInterface port = service.getWSImplPort();
     
                // TODO process result here
                com.mycompany._soap_server.Professor res = port.getDetails(id);
                System.out.println("Ricevuto id : " + id + " con ranking " + ranking + " ....." + "bravo " + res.getName() + " " + res.getSurname());
            } else {
                System.out.println("Message of wrong type : " + msg.getClass().getName());
            }
        } catch (JMSException ex) {
            Logger.getLogger(ProfessorListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
