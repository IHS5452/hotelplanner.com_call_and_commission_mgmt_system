/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import UI.UI_main;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ian
 */
public class general {
    
    
    public static String generateCallID() {
        
        return "12345-TEST";
    }
    
    public static String todaysDate() {
        
        return "1_1_1900";
    }
    
       
    public static String generatePunchID() {
        
        return "54321-TEST";
    }
    
    
    public static void getDeailsOfCLockIn(String timesheetID) {
        try {
            String SQL_ClockInDetials = "SELECT * FROM timesheets WHERE TSID=\"" + timesheetID + "\";";
            Connection cnn = database.actions.returnConn();
            
            Statement st = cnn.createStatement();
            
            
            ResultSet rs = st.executeQuery(SQL_ClockInDetials);
            
            
            
            if(rs.next()) {
                String clockInTime = rs.getString("clockInTime");
                String clockInDate = rs.getString("clockInDate");
                String clockOutTime = rs.getString("clockOutTime");
                String clockOutDate = rs.getString("clockOutDate");
                String hoursWorked = rs.getString("hoursWorked");
                String salesMade = rs.getString("salesMade");
                String callsRcvd = rs.getString("callsRcvd");
                
                
                
                classes.timestamp.setCallsTkn(callsRcvd);
               classes.timestamp.setSalesMd(salesMade);
                classes.timestamp.setHrsWorked(hoursWorked);
                classes.timestamp.setClkInDt(clockInDate);
                classes.timestamp.setClkInTm(clockInTime);
                classes.timestamp.setClkOutDt(clockOutDate);
                classes.timestamp.setClkOutTm(clockOutTime);

                
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(general.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static void startup() {
        System.out.println("Calling the startup class");
        try {
            String SQL1 = "SELECT * FROM vars";
            Connection cnn = database.actions.returnConn();
            
            Statement st = cnn.createStatement();
            
            
            ResultSet rs = st.executeQuery(SQL1);
            
            
            
            if(rs.next()) {
                        System.out.println("getting the data from the vars DB table");

                String CurrentTimestampID = rs.getString("crntTSID");
                String isCLockedIn = rs.getString("isClockedIn");
                
                classes.generalVars.setIsClockedIn(isCLockedIn);
                classes.generalVars.setCureentTMSH(CurrentTimestampID);
            }
                    System.out.println(classes.generalVars.getCureentTMSH());

            if (classes.generalVars.getIsClockedIn().equals("Y")) {
                getDeailsOfCLockIn(classes.generalVars.getCureentTMSH());
                UI_main.isInOUt.setText("In");
                UI_main.cioBTN.setText("Clock Out");
                UI_main.timeCI.setText(classes.timestamp.getClkInTm());
            }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(general.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
    
}
