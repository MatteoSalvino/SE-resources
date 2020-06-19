package com.mycompany.test2_server;


import com.mycompany.test2_server.Passenger;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@XmlRootElement(name = "Flight")
public class Flight {
    private Integer id;
    private String code;
    private String source;
    private String destination;
    private String time;
    private List<Passenger> passengers;
    
    
    public Flight(Integer _id, String _code, String _source, String _destination, String _time) {
        this.id = _id;
        this.code = _code;
        this.source = _source;
        this.destination = _destination;
        this.time = _time;
        this.passengers = new ArrayList<Passenger>();
    }
    
    public Flight() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @GET
    @Path("")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    @POST
    @Path("")
    public Response createPassenger(Passenger passenger) {
        if(this.passengers == null)
            this.passengers = new ArrayList<Passenger>();
        
        Passenger pass = findById(passenger.getId());
        
        if(pass != null)
            return Response.status(Response.Status.CONFLICT).build();
        this.passengers.add(passenger);
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Path("{passengerId}")
    public Passenger getPassenger(@PathParam("passengerId") Integer passengerId) {
        return findById(passengerId);
    }
    
    @PUT
    @Path("{passengerId}")
    public Response updatePassenger(@PathParam("passengerId") Integer passengerId, Passenger passenger) {
        Passenger pass = findById(passengerId);
        
        if(pass == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        if(passengerId.compareTo(passenger.getId()) != 0)
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        if(pass.equals(passenger))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        
        this.passengers.remove(pass);
        this.passengers.add(passenger);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("{passengerId}")
    public Response deletePassenger(@PathParam("passengerId") Integer passengerId) {
        Passenger passenger = findById(passengerId);
        
        if(passenger == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        this.passengers.remove(passenger);
        return Response.status(Response.Status.OK).build();
    }
    
    @Override
    public String toString() {
        return "Flight{id: " + this.id + ", code: " + this.code + ", source: " + this.source + ", destination: " + this.destination + ", time: " + this.time + "}";
    }

    @Override
    public boolean equals(Object o) {
        Flight obj = (Flight) o;
        return this.id == obj.id && this.code == obj.code && this.source == obj.source && this.destination == obj.destination && this.time == obj.time;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + super.hashCode();
    }

    private Passenger findById(Integer passengerId) {
        if(this.passengers == null)
            return null;
        
        Integer size = this.passengers.size();
        for(int i = 0; i < size; i++) {
            Passenger pass = this.passengers.get(i);
            if(pass.getId().compareTo(passengerId) == 0)
                return pass;
        }
        return null;
    }
}
