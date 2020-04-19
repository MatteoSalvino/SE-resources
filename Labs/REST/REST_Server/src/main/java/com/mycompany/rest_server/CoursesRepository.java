/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest_server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author studente
 */
@Path("/courses")
@Produces("text/xml")
public class CoursesRepository {
    private Map<Integer, Course> courses = new HashMap<>();
    
    {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setId(1);
        student1.setName("Student A");
        student2.setId(2);
        student2.setName("Student B");

        List<Student> course1Students = new ArrayList<>();
        course1Students.add(student1);
        course1Students.add(student2);

        Course course1 = new Course();
        Course course2 = new Course();
        course1.setId(1);
        course1.setName("REST with Spring");
        course1.setStudents(course1Students);
        course2.setId(2);
        course2.setName("Learn Spring Security");

        courses.put(1, course1);
        courses.put(2, course2);
    }
    
    
    @GET
    @Path("{courseId}")
    public Course getCourse(@PathParam("courseId") int courseId) {
        return findById(courseId);
    }
    
    @PUT
    @Path("{courseId}")
    public Response updateCourse(@PathParam("courseId") int courseId, Course course) {
        Course ex_course = findById(courseId);
        
        if(ex_course == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        if(ex_course.equals(course))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        
        this.courses.put(courseId, course);
        return Response.ok().build();
    }
    
    @Path("{courseId}/students")
    public Course pathToStudents(@PathParam("courseId") int courseId) {
        return findById(courseId);
    }
    
    private Course findById(int id) {
        for(Map.Entry<Integer, Course> course : this.courses.entrySet()) {
            if(course.getKey() == id) {
                return course.getValue();
            }
        }
        return null;
    }
    
}
