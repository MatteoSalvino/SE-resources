package com.mycompany.test2_server;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@XmlRootElement(name = "Passenger")
class Passenger {
    private Integer id;
    private String name;

    public Passenger(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Passenger() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Passenger{id: " + this.id + ", name: " + this.name + "}";
    }

    @Override
    public boolean equals(Object o) {
        Passenger obj = (Passenger) o;
        return this.id == obj.id && this.name == obj.name;
    }

    @Override
    public int hashCode() {
        return this.id + super.hashCode(); 
    }    
}
