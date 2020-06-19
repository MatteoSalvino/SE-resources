package com.mycompany.test2_server;


import com.mycompany.test2_server.Flight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@Path("/flights")
@Produces("text/xml")        
public class FlightsRepository {
    
    private Map<Integer, Flight> flights =  new HashMap<Integer, Flight>();
    
  
    @GET
    @Path("")
    public List<Flight> getFlights() {
        List<Flight> to_ret = new ArrayList<Flight>();
        
        for(Map.Entry<Integer, Flight> elem : this.flights.entrySet()) 
            to_ret.add(elem.getValue());
        return to_ret; 
    }
    
    @POST
    @Path("")
    public Response createFlight(Flight flight) {
        Flight obj = findById(flight.getId());
        
        if(obj != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        
        this.flights.put(this.flights.size(), flight);
        return Response.status(Response.Status.CREATED).build();    
    }
    
    @GET
    @Path("{flightId}")
    public Flight getFlight(@PathParam("flightId") Integer flightId) {
        return findById(flightId);
    }
    
    @PUT
    @Path("{flightId}")
    public Response updateFlight(@PathParam("flightId") Integer flightId, Flight flight) {
        Flight obj = findById(flightId);
        
        if(obj == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        if(obj.equals(flight))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        if(flightId.compareTo(flight.getId()) != 0)
            return Response.status(Response.Status.BAD_REQUEST).build();
       
        this.flights.put(flightId, flight);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("{flightId}")
    public Response deleteFlight(@PathParam("flightId") Integer flightId) {
        Flight flight = findById(flightId);
        //System.out.println("To remove : " + flight);
        
        if(flight == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        this.flights.remove(flightId);
        return Response.status(Response.Status.OK).build();
    }
    
    @Path("{flightId}/passengers")
    public Flight pathToPassengers(@PathParam("flightId") Integer flightId) {
        return findById(flightId);
    }

    private Flight findById(Integer id) {
        for(Map.Entry<Integer, Flight> elem : this.flights.entrySet()) {
            Flight flight = elem.getValue();
            System.out.println(flight);
            if(flight.getId().compareTo(id) == 0)
                return flight;
        }
        return null;
    }  
}
