/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ian
 */
public class actions {
   
    public static String dbName = "hotelplannersystem";
     public static Statement stmt = null;
     public static Connection conn = null;
    
    public static void connect() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName,"root","Polpper@1");
//here sonoo is database name, root is username and password
                stmt=conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connection returnConn() {
        return conn;
    }
    
    
    
}
