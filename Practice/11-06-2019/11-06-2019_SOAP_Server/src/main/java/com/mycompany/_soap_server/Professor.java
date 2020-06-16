/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "professor")
public class Professor {
    private Integer ID;
    private String name;
    private String surname;
    
    public Professor(String _name, String _surname) {
        this.name = _name;
        this.surname = _surname;
    }

    @XmlElement(name = "ID")
    public void setID(Integer ID) {
        this.ID = ID;
    }

    
    public Integer getID() {
        return ID;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @XmlElement(name = "surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Professor{" + "name=" + name + ", surname=" + surname + '}';
    }
}
