/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json_client;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author studente
 */
@JacksonXmlRootElement(localName = "Flight")
public class Flight {
    private int id;
    private String name;

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
        return "Flight with id = " + this.id + " and name = " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Flight) && this.id == ((Flight) o).getId() && this.name.equals(((Flight) o).getName());
    }

    @Override
    public int hashCode() {
        return this.id + super.hashCode();
    }
}
