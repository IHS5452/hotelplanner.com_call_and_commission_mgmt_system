/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;


import classes.sale;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ian-laptop
 */
public class getFromDatabase {
    
    
    public static List<sale> sale(String callID, String saleID) {
         List<sale> salesList = new ArrayList<>();

        ResultSet rs = null;
         Statement stmt = null;
       Connection conn = null;

        try {
              conn = database.actions.returnConn();
       stmt = conn.createStatement();
            String sql = "SELECT * FROM sales where sale_id='" + saleID + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String saleId = rs.getString("sale_id");
                String callId = rs.getString("call_id");
                String callStatus = rs.getString("call_status");
                Date callDate = rs.getDate("call_date");
                boolean isPrepaid = rs.getBoolean("is_prepaid");
                Date checkInDate = rs.getDate("check_in_date");
                
                //pausing the parsing from db to conver the date to a localdate. this is needed later
                String[] splitChekcInDate = checkInDate.toString().split("-"); 
                
                int year = Integer.parseInt(splitChekcInDate[0]);
                int month = Integer.parseInt(splitChekcInDate[1]);
                int day = Integer.parseInt(splitChekcInDate[2]);

                LocalDate localdate_checkIn = LocalDate.of(year, month, day);
                
                
                
                //resuming
                Date checkOutDate = rs.getDate("check_out_date");
                //pausing the parsing again from db to conver the date to a localdate. this is needed later
                String[] splitChekOutDate = checkOutDate.toString().split("-"); 
                
                int year2 = Integer.parseInt(splitChekOutDate[0]);
                int month2 = Integer.parseInt(splitChekOutDate[1]);
                int day2 = Integer.parseInt(splitChekOutDate[2]);

                LocalDate localdate_checkOut = LocalDate.of(year2, month2, day2);
                
                //resuming
                boolean isPaidOut = rs.getBoolean("is_paid_out");
                Date paidOutDate = rs.getDate("paid_out_date");
                String hotelName = rs.getString("hotel_name");
                int totalBill = rs.getInt("total_bill");
                int commissionPercentage = rs.getInt("commission_percentage");
                int totalCommission = rs.getInt("total_commission");
                boolean isCanceledBooking = rs.getBoolean("is_canceled_booking");
                Date canceledDate = rs.getDate("canceled_date");

                sale sale = new sale(saleId, callId, callStatus, callDate, isPrepaid, localdate_checkIn,  localdate_checkOut,
                        isPaidOut, paidOutDate, hotelName, totalBill, commissionPercentage, totalCommission,
                        isCanceledBooking, canceledDate);
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
//        finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (stmt != null) {
//                    stmt.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        
//    }
        return salesList;
    
}
}
