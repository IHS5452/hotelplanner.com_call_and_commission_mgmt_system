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
   
    
    public static void commission(String isPrepaid, String chkinDt, String chkOutDt,String ChkInTm, String ChkOutTm, String rmNumb, String ngtNumb, String HotelName, String ttlBill, String ttlPerc, String ttlComm) {
        try {
            String sql = "INSERT INTO sales VALUES(\"" + business.general.generateCallID() + "\",\"confirmed\",\"" + business.general.todaysDate() + "\",\""
                    + isPrepaid + "\",\"" + chkOutDt+ "\",\"" + chkinDt+ "\",\"" + "N" + "\",\"" + "NA" + "\",\"" + HotelName + "\",\"" + ttlBill + "\",\"" +ttlPerc + "\",\"" + ttlComm +
                     "\",\"" +"N"+ "\",\"" +"NA" + "\");";
            
            Connection cnn = database.actions.returnConn();
            
            Statement stmt = (Statement) cnn.createStatement();
            
                  stmt.executeUpdate(sql);

                  UI_main.AddToOutputArea("Added Sucesfully.");
                  
                  
        } catch (SQLException ex) {
                        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);

                              UI_main.AddToOutputArea(ex.getMessage());
        }
        
    }
    
    
    public static void clockIn(String timeIn, String dateIn) {
        
        try {
            String sql = "INSERT INTO timesheets VALUES(\"" + business.general.generatePunchID() + "\",\"" + timeIn + "\",\"" + dateIn + "\",\"" + "TBA" + "\",\"" + "TBA" + "\",\"" +
                   "TBA" + "\",\"" + "TBA" + "\",\"" + "TBA" + "\");";
            Connection cnn = database.actions.returnConn();
            
            Statement stmt = (Statement) cnn.createStatement();
            
            stmt.executeUpdate(sql);
            
            UI_main.AddToOutputArea("Clocked In Sucesfully.");
        } catch (SQLException ex) {
            Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
                                          UI_main.AddToOutputArea(ex.getMessage());

        }
    }
    
    
    
    
    
    public static void call_saleNotLinked(String callStartTime, String callEndTime, String callStartDate, String callEndDate, String notesAboutCall) {
        
        
        
        
    }
    
    
    
    
}
