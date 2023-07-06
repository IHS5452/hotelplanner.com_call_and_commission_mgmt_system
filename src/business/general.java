/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import UI.UI_main;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ian
 */
public class general {
    
       public static String generateSaleID() {
      // Generate random 5-digit number
        Random random = new Random();
        int randomNum = random.nextInt(90000) + 10000;
        String randomNumString = String.valueOf(randomNum);
 
        
        
        // Combine the generated parts to form the call ID
        String callID = "S"+randomNumString + "-" + generateRandom3DigitNumber() + "-" + todaysdate();
        return callID;    
    } 
    public static String generateCallID() {
      // Generate random 5-digit number
        Random random = new Random();
        int randomNum = random.nextInt(90000) + 10000;
        String randomNumString = String.valueOf(randomNum);
 
        
        
        // Combine the generated parts to form the call ID
        String callID = "C"+randomNumString + "-" + generateRandom3DigitNumber() + "-" + todaysdate();
        return callID;    
    }
    
    public static String todaysdate() {
             
           LocalDateTime currentDate = LocalDateTime.now();  
           System.out.println(currentDate);

        String newstring = currentDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        
        return newstring;
    }

      
//            public static String todaysDateAndCurrentTime() {
//             SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy ");
//        LocalDate currentDate = LocalDate.now();
//        String date = dateFormat.format(currentDate);
//        return date;
//    }
       
    public static String generatePunchID() {
   Random random = new Random();
        int randomNum1 = random.nextInt(90000) + 10000;
        String randomNumStringOne = String.valueOf(randomNum1);
 
                int randomNum2 = random.nextInt(90000) + 10000;
        String randomNumStringTwo = String.valueOf(randomNum2);
        
        // Combine the generated parts to form the call ID
        String callID = "P"+randomNumStringOne + "-" + randomNumStringTwo+ "-" + todaysdate();
        return callID;
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
            String SQL1 = "SELECT current_timesheet_id, is_clocked_in FROM app_data";
            Connection cnn = database.actions.returnConn();
            
            Statement st = cnn.createStatement();
            
            
            ResultSet rs = st.executeQuery(SQL1);
            
            
            
            if(rs.next()) {
                        System.out.println("getting the data from the vars DB table");

                String CurrentTimestampID = rs.getString("current_timesheet_id");
                String isCLockedIn = rs.getString("is_clocked_in");
                
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
    
     private static String generateRandom3DigitNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(900) + 100;
        return String.valueOf(randomNum);
    }
    
  
    
}
