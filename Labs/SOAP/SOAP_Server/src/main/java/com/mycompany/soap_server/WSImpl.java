/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface="com.mycompany.soap_server.WSInterface")
public class WSImpl implements WSInterface {
    private Map<Integer, Student> students = new LinkedHashMap<Integer, Student>();
    
    @Override
    public String helloStudent(Student stud) {
        this.students.put(this.students.size() + 1, stud);
        return "Hello " + stud.getName();
    }

    @Override
    public Map<Integer, Student> getStudents() {
        return this.students;
    }
}
