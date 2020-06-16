/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1_dbmanager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author studente
 */
public class DBManager {
    public static String url = "jdbc:sqlite:/home/studente/Desktop/test1_db";
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
        createDB();
        createTables();
        initTables();
    }
    
    public static void createDB() {   
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DBManager.url);
            
            System.out.println("A new database has been created.");
            
        } catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS MANAGERS("
                                                        + "ID numeric PRIMARY KEY, "
                                                        + "name varchar(300),"
                                                        + "surname varchar(300));";
        
        try {
            Connection conn = DriverManager.getConnection(DBManager.url);
            Statement stat = conn.createStatement();
            stat.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        sql = "CREATE TABLE IF NOT EXISTS EVENTS("
                                                        + "ID numeric PRIMARY KEY, "
                                                        + "name varchar(300),"
                                                        + "date date,"
                                                        + "managerID varchar(300),"
                                                        + "FOREIGN KEY(managerID)  REFERENCES MANAGERS(id));";
        try {
            Connection conn = DriverManager.getConnection(DBManager.url);
            Statement stat = conn.createStatement();
            stat.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static void initTables() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(DBManager.url);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < 20; i++) {
            try {
                PreparedStatement prepStat = conn.prepareStatement("INSERT INTO MANAGERS(ID,name,surname) values (?, ?, ?);");
                prepStat.setInt(1, i);
                prepStat.setString(2, "name_" + i);
                prepStat.setString(3, "surname_" + i);
                prepStat.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int i = 0; i < 20; i++) {
            try {
                PreparedStatement prepStat = conn.prepareStatement("INSERT INTO EVENTS(ID,name,date,managerID) values (?, ?, ?, ?);");
                prepStat.setInt(1, i);
                prepStat.setString(2, "event_" + i);
                prepStat.setDate(3, new Date(120, 9, i));
                prepStat.setInt(4, i % 5);
                prepStat.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

        
    
   
}
