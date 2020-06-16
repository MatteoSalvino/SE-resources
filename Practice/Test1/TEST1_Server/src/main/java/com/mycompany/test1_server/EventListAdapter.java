/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_server;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
class EventListAdapter extends XmlAdapter<String, List<Event>> {

    @Override
    public List<Event> unmarshal(String value) throws Exception {
        List<Event> events = new ArrayList<Event>();
     
        String[] data = value.split("*");
        Integer data_length = data.length;
        
        for(int i = 0; i < data_length; i++) {
            String[] elem = data[i].split(",");
            Event event = new Event(elem[1], Date.valueOf(elem[2]), Integer.valueOf(elem[3]));
            event.setID(Integer.valueOf(elem[0]));
            events.add(event);
        }
        return events;
    }

    @Override
    public String marshal(List<Event> events) throws Exception {
        
        String res = "";
        Integer events_size = events.size();
        
        for(int i = 0; i < events_size; i++) {
            Event elem = events.get(i);
            res += elem.getID() + "," + elem.getName() + "," + elem.getDate() + "," + elem.getManagerID() + "*";
        }
        return res;
    }
    
}
