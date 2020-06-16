/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_server;

import java.util.List;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@WebService
public interface WSInterface {
    @XmlJavaTypeAdapter(EventListAdapter.class)
    public List<Event> getEvents();
    /*
    @param id of an event
    @return the event with the given id
    */      
    public Event getEvent(Integer id);
    
    /*
    @param id of a manager
    @return the Manager with the given id
    */
    public Manager getManager(Integer id);
}
