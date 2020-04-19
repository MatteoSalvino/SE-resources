/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "Student")
public class StudentImpl implements Student {
    private String name;
    
    public StudentImpl(String n) { this.name = n; }
    
    public StudentImpl() {}
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
