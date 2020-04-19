/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_server;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "StudentMap")
public class StudentMap {
    private List<StudentEntry> students = new LinkedList<StudentEntry>();
    
    @XmlElement(nillable = false, name = "entry")
    public List<StudentEntry> getStudents() {
        return this.students;
    }

    @XmlType(name = "StudentEntry")
    public static class StudentEntry {
        private Integer id;
        private Student student;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }
}
