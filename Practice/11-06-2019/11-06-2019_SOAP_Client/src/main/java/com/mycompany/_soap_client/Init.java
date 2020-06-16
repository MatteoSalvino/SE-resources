/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_client;

import javax.jms.JMSException;

/**
 *
 * @author studente
 */
public class Init {
    public static void main(String args[]) throws JMSException {
        new ProfessorListener("dynamicTopics/professors").start();
    }
    
}
