/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface="com.mycompany.test1_server.WSInterface")
class WSImpl implements WSInterface {
    public static String url = "jdbc:sqlite:/home/studente/Desktop/test1_db";

    @Override
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<Event>();
        String sql = "SELECT * FROM EVENTS;";
        
        try {
            Connection conn = this.connect();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Event event = new Event(res.getString("name"), res.getDate("date"), res.getInt("managerID"));
                event.setID(res.getInt("ID"));
                events.add(event);
            }          
        } catch (SQLException ex) {
            Logger.getLogger(WSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    @Override
    public Event getEvent(Integer id) {
        Event event = null;
        try {
            Connection conn = this.connect();
            String sql = "SELECT * FROM EVENTS WHERE ID = ?;";
            PreparedStatement prepStat = conn.prepareStatement(sql);
            prepStat.setInt(1, id);
            ResultSet res = prepStat.executeQuery();
            
            while(res.next()) {
                event = new Event(res.getString("name"), res.getDate("date"), res.getInt("managerID"));
                event.setID(res.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public Manager getManager(Integer id) {
        Manager manager = null;
        try {
            Connection conn = this.connect();
            String sql = "SELECT * FROM MANAGERS WHERE ID = ?;";
            PreparedStatement prepStat = conn.prepareStatement(sql);
            prepStat.setInt(1, id);
            ResultSet res = prepStat.executeQuery();
            
            while(res.next()) {
                manager = new Manager(res.getString("name"), res.getString("surname"));
                manager.setID(res.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manager;
    }
    
    private Connection connect() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(WSImpl.url);
        } catch (SQLException ex) {
            Logger.getLogger(WSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
