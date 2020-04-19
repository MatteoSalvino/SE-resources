/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_server;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */

@XmlRootElement(name = "Student")
public class Student {
    private int id;
    private String name;
    
    public Student(int _id, String _name) {
        this.id = _id;
        this.name = _name;
    }
    
    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Student) && (this.id == ((Student) o).getId()) && (this.name == ((Student) o).getName()));
    }

    @Override
    public int hashCode() {
        return this.id + super.hashCode();
    }    
}
