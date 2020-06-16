/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_server;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author studente
 */
public class Manager {
    private Integer ID;
    private String name;
    private String surname;
    
    public Manager(String _name, String _surname) {
        this.name = _name;
        this.surname = _surname;
    }
    
    @XmlElement(name = "ID")
    public void setID(Integer id) {
        this.ID = id;
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
        return "Manager{" + "ID=" + ID + ", name=" + name + ", surname=" + surname + '}';
    }
}
