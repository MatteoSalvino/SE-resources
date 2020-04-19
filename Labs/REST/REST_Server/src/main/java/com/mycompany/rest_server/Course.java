/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_server;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import static org.apache.cxf.jaxrs.model.ParameterType.PATH;

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
    
    @GET
    @Path("{studentId}")
    public Student getStudent(@PathParam("studentId") int studentId) {
        return findById(studentId);
    }
    
    @POST
    @Path("")
    public Response createStudent(Student student) {
        if(this.students == null)
            this.students = new ArrayList<Student>();
        
        for(Student elem : this.students) {
            if(elem.getId() == student.getId())
                return Response.status(Response.Status.CONFLICT).build();
        }
        
        this.students.add(student);
        return Response.ok(student).build();
    }
    
    @DELETE
    @Path("{studentId}")
    public Response deleteStudent(@PathParam("studentId") int studentId) {
        int size = this.students.size();
        
        Student student =findById(studentId);
        
        if(student == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        this.students.remove(student);
        return Response.ok().build();
    }
    
    @Override
    public String toString() {
        return this.id + " " + this.name; 
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Course) && (this.id  == ((Course) o).getId()) && (this.name == ((Course)o).getName()));
    }

    @Override
    public int hashCode() {
        return this.id + super.hashCode();
    }    

    private Student findById(int studentId) {
       if(this.students == null)
           return null;
       
       int size = this.students.size();
       
       for(int i = 0; i < size; i++) {
        if(this.students.get(i).getId() == studentId)
            return this.students.get(i);
       }
       return null;
    }
}
