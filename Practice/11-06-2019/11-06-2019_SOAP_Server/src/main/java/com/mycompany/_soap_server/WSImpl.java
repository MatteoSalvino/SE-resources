/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._soap_server;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import com.mycompany._soap_server.Professor;

/**
 *
 * @author studente
 */
@WebService(endpointInterface="com.mycompany._soap_server.WSInterface")
public class WSImpl implements WSInterface {
    private List<Professor> professors;
    
    public WSImpl() {
        professors = new ArrayList<Professor>();
        this.initData();
    }

    @Override
    public Professor getDetails(String id) {
        int size = professors.size();
        
        for(int i = 0; i < size; i++) {
            if(professors.get(i).getID() == Integer.valueOf(id))
                return professors.get(i);
        }
        return null;
    }
    
    private void initData() {
        Professor p1 = new Professor("Massimo", "Mecella");
        p1.setID(0);
        Professor p2 = new Professor("Giuseppe", "De Giacomo");
        p2.setID(1);
        Professor p3 = new Professor("Fabrizio", "D' amore");
        p3.setID(2);
        
        this.professors.add(p1);
        this.professors.add(p2);
        this.professors.add(p3);
    }
    
}
