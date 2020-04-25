/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbsimplemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author studente
 */
public class DBManager {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + args[0]);
        
        Statement stat = conn.createStatement();
        
        if(args[1].equals("create")) {
            
            stat.executeUpdate("drop table if exists flights;");
            stat.executeUpdate("create table flights (id, name);");
            
            PreparedStatement prepStat = conn.prepareStatement("insert into flights values (?, ?);");

            prepStat.setString(1, "1");
            prepStat.setString(2, "AU203");
            prepStat.addBatch();
            conn.setAutoCommit(false);
            prepStat.executeBatch();
            conn.setAutoCommit(true);

            prepStat.setString(1, "2");
            prepStat.setString(2, "TX863");
            prepStat.addBatch();
            conn.setAutoCommit(false);
            prepStat.executeBatch();
            conn.setAutoCommit(true);   

            prepStat.setString(1, "3");
            prepStat.setString(2, "DA843");
            prepStat.addBatch();
            conn.setAutoCommit(false);
            prepStat.executeBatch();
            conn.setAutoCommit(true);

            prepStat.setString(1, "4");
            prepStat.setString(2, "GR403");
            prepStat.addBatch();
            conn.setAutoCommit(false);
            prepStat.executeBatch();
            conn.setAutoCommit(true);            
            
        } else {
            ResultSet rs = stat.executeQuery("select * from flights;");
            
            while(rs.next()) 
                System.out.println("Flight : (" + rs.getString("id") + ", " + rs.getString("name") + ")");
            
            rs.close();
        }
        conn.close();
    }
    
}
