/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
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
@Path("/flights")
public class FlightsRepository {
    private Connection conn;

    public void setConnection(String arg) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FlightsRepository.class.getName()).log(Level.SEVERE, null, ex);            }
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + arg);
        } catch (SQLException ex) {
            Logger.getLogger(FlightsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @GET
    @Path("{flightId}")
    @Produces("application/json")
    
    public Flight getFlight(@PathParam("flightId") int flightId) {
        return findById(flightId);
    }
    
    
    @PUT
    @Path("{flightId}") 
    @Consumes("application/json")
    
    public Response updateFlight(@PathParam("flightId") int flightId, Flight flight) {
        Flight existing = findById(flightId);
        
        if(existing == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        if(existing.equals(flight))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        
        update(flightId, flight);
        return Response.ok().build();
    }
    

    private Flight findById(int flightId) {
        PreparedStatement prepStat = null;
        Flight to_ret = null;
        
        try {
            prepStat = this.conn.prepareStatement("select * from flights where id = ?");
            prepStat.setString(1, String.valueOf(flightId));
            
            ResultSet rs = prepStat.executeQuery();
            
            if(rs.next()) {
                to_ret = new Flight();
                
                to_ret.setId(Integer.parseInt(rs.getString("id")));
                to_ret.setName(rs.getString("name"));
                
                System.out.println("[Accessed] " + to_ret);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FlightsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return to_ret;
    }

    private void update(int flightId, Flight flight) {
        PreparedStatement prepStat = null;
        
        try {
            prepStat = conn.prepareStatement("update flights set name = ? where id = ?");
            
            prepStat.setString(1, flight.getName());
            prepStat.setString(2, String.valueOf(flightId));
            
            int affectedRow = prepStat.executeUpdate();
            
            if(affectedRow == 1) {
                System.out.println("[Updated] " + flight);
                return;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
