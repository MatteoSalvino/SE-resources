/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_server;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "Event")
public class Event {
    Integer ID;
    String name;
    Date date;
    Integer managerID;

    public Event(String _name, Date _date, Integer _managerID) {
        this.name = _name;
        this.date = _date;
        this.managerID = _managerID;
    }

    @XmlElement(name = "id")
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
    
    @XmlElement(name = "date")
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement(name = "managerID")
    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }
    
    public Integer getManagerID() {
        return managerID;
    }

    @Override
    public String toString() {
        return "Event{" + "ID=" + ID + ", name=" + name + ", date=" + date + ", managerID=" + managerID + '}';
    }  
}
