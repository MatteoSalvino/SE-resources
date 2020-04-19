/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class StudentMapAdapter extends XmlAdapter<StudentMap, Map<Integer, Student>> {

    @Override
    public Map<Integer, Student> unmarshal(StudentMap values) throws Exception {
        Map<Integer, Student> map = new LinkedHashMap<Integer, Student> ();
        
        for(StudentMap.StudentEntry entry : values.getStudents()) {
            map.put(entry.getId(), entry.getStudent());
        }
        
        return map;
    }

    @Override
    public StudentMap marshal(Map<Integer, Student> map) throws Exception {
        StudentMap values = new StudentMap();
        
        for(Map.Entry<Integer, Student> entry : map.entrySet()) {
            StudentMap.StudentEntry stud_entry = new StudentMap.StudentEntry();
            stud_entry.setStudent(entry.getValue());
            stud_entry.setId(entry.getKey());
            
            values.getStudents().add(stud_entry);
        }
        
        return values;
    }
}
