/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_server;

import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService
public interface WSInterface {
    public Professor getDetails(String id); 
}
