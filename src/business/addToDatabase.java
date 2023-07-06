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
   

    
   public  static void sale(int isPrepaid, String chkinDt, String chkOutDt, String ChkInTm, String ChkOutTm, String rmNumb, String ngtNumb, String HotelName, String ttlBill, String ttlPerc, String ttlComm) {
    try {
        String callID = business.general.generateCallID();
        String sql = "INSERT INTO calls (call_status, call_date, is_prepaid) VALUES ('confirmed', CURDATE(), '" + isPrepaid + "')";
        
        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
        String saleID = general.generateSaleID();
        
        
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            String callId = general.generateCallID();
sql = "INSERT INTO sales (sale_id, call_id, call_status, call_date, is_prepaid, check_in_date, check_out_date, is_paid_out, paid_out_date, hotel_name, total_bill, commission_percentage, total_commission, is_canceled_booking, canceled_date) VALUES ('" + saleID + "', '" + callID + "', 'confirmed', CURDATE(), '" + isPrepaid + "', '" + chkinDt + "', '" + chkOutDt + "', 0, NULL, '" + HotelName + "', " + ttlBill + ", " + ttlPerc + ", " + ttlComm + ", '0', 'NA')";

            stmt.executeUpdate(sql);
            
            UI_main.AddToOutputArea("Added Successfully.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }
}
   
   
   
   
      
    
    
    public static void noSale(String callStartTime, String callEndTime, String callStartDate, String callEndDate) {
        
            try {
        String callID = business.general.generateCallID();
        String sql = "INSERT INTO calls (call_status, call_date, is_prepaid) VALUES ('noSale', CURDATE(), '" + "NULL" + "')";

        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            String callId = general.generateCallID();
            sql = "INSERT INTO sales (CallID, call_status, call_date, is_prepaid, check_out_date, check_in_date, hotel_name, total_bill, commission_percentage, total_commission, is_canceled_booking, canceled_date) VALUES ('"
                    + callID + "', 'noSale', CURDATE(), "+
                    "NULL, NULL, NULL, "
                    + "NULL," + "0.00" + ", " + "35" + ", " + "0.00" + ", 'NULL', 'NULL')";
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
        String sql = "INSERT INTO time_punches (user_id, clock_in_time, is_recovered) VALUES (1, '" + dateIn + " " + timeIn + "', false)";
        
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
        String sql = "SELECT punch_id FROM time_punches WHERE is_recovered = false ORDER BY punch_id DESC LIMIT 1";
        
        Connection cnn = database.actions.returnConn();
        Statement stmt = cnn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        if (rs.next()) {
            int punchId = rs.getInt("punch_id");
            
            sql = "UPDATE time_punches SET clock_out_time = '" + dateOut + " " + timeOut + "' WHERE punch_id = " + punchId;
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
    
