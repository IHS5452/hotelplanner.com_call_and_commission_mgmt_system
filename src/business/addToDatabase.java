/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import UI.UI_main;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ian
 */
public class addToDatabase {
   

    
   public  static void sale(int isPrepaid, String chkinDt, String chkOutDt, String rmNumb, String ngtNumb, String HotelName, String ttlBill, String ttlPerc, String ttlComm) {
    try {
        String callID = business.general.generateCallID();
                String saleID = business.general.generateSaleID();

        System.out.println("Going to the calls insert");

String sql = "INSERT INTO calls VALUES ('" + callID + "','confirmed', CURDATE(), " + isPrepaid + ", '" + saleID + "')";
    
        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
sql = "INSERT INTO sales VALUES ('" + saleID + "', '" + callID + "', 'confirmed', CURDATE(), " + isPrepaid + ", '" + chkinDt + "', '" + chkOutDt + "', 0, '1990-01-01', '" + HotelName + "', " + ttlBill + ", " + ttlPerc + ", " + ttlComm + ", 0, '1900-01-01')";
            Connection cnn2 = database.actions.returnConn();

            Statement stmt2 = cnn.createStatement();
        stmt2.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = stmt.getGeneratedKeys();
        
            
            UI_main.AddToOutputArea("Added Successfully.");
        
        
    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }
}
   
   
   
   
      
    
    
    public static void noSale(String callStartTime, String callEndTime, String callStartDate, String callEndDate) {
        
            try {
        String callID = business.general.generateCallID();
                System.out.println(callID);
        String saleID = business.general.generateSaleID();
                        System.out.println(saleID);

        String sql = "INSERT INTO calls  VALUES ('" + callID + "','noSale', CURDATE(), '" + "NULL" + "')";

        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            String callId = general.generateCallID();
            sql = "INSERT INTO sales  VALUES ('"+ saleID + "','"
                    + callID + "', 'noSale', CURDATE(), "+
                    "NULL, NULL, NULL, "
                    + "NULL','NULL'" + "0.00" + ", " + "35" + ", " + "0.00" + ", 'NULL', 'NULL')";
            stmt.executeUpdate(sql);

            UI_main.AddToOutputArea("Added Successfully.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }
}
   
   
   
   

public static void clockIn(String timeIn, String dateIn) {
    try {
String sql = "INSERT INTO time_punches (punch_id, user_id, clock_in_time, is_recovered) VALUES ('" + business.general.generatePunchID() + "', 1, '" + dateIn + " " + timeIn + "', false)";
        
        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            String punchId = general.generatePunchID();
            
            sql = "INSERT INTO timesheets (clockInTime, clockInDate) VALUES ('" + timeIn + "', '" + dateIn + "')";
            stmt.executeUpdate(sql);
            
            classes.generalVars.setCureentTMSH(punchId);
            UI_main.AddToOutputArea("Clocked In Successfully.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }
}


public static void clockOut(String timeOut, String dateOut) {
    try {
        String sql = "SELECT * FROM time_punches ORDER BY punch_id";
        
        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        if (rs.next()) {
            String punchId = rs.getString("punch_id");
            
            sql = "UPDATE time_punches SET clock_out_time = '" + dateOut + " " + timeOut + "' WHERE punch_id = '" + punchId + "';";
            stmt.executeUpdate(sql);

            UI_main.AddToOutputArea("Clocked Out Successfully.");
        } else {
            UI_main.AddToOutputArea("No active clock-in found.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }
}

        
        
    }
    
