/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._jms_server;

/**
 *
 * @author studente
 */
public class Init {
    public static void main(String[] args) {
        new Publisher("dynamicTopics/professors").start();
    }
    
}
