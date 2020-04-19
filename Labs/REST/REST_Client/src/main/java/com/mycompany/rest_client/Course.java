/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */

@XmlRootElement(name = "Course")
public class Course {
    private int id;
    private String name;
    private List<Student> students;
    
    public Course(int _id, String _name) {
        this.id = _id;
        this.name = _name;
        this.students = new ArrayList<Student>();
    }
    
    public Course() {}

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " with " + ((this.students == null) ? 0 : this.students.size()) + " students"; 
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Course) && (this.id  == ((Course) o).getId()) && (this.name == ((Course)o).getName()));
    }

    @Override
    public int hashCode() {
        return this.id + super.hashCode();
    }    
}
