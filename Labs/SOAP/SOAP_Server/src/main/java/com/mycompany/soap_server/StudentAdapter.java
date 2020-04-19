/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class StudentAdapter extends XmlAdapter<StudentImpl, Student> {

    @Override
    public Student unmarshal(StudentImpl stud) throws Exception {
       return stud; 
    }

    @Override
    public StudentImpl marshal(Student stud) throws Exception {
        if(stud instanceof StudentImpl)
            return (StudentImpl) stud;
        return new StudentImpl(stud.getName());
    }
}
