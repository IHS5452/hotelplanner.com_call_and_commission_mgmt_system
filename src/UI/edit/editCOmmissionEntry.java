/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.edit;

import UI.UI_main;
import business.addToDatabase;
import classes.sale;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author iansc
 */
public class editCOmmissionEntry extends javax.swing.JFrame {

    /**
     * Creates new form editCOmmissionEntry
     */
    public editCOmmissionEntry() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        commissionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        status_combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dateOfCall = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        checkInDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        checkOutDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rooms = new javax.swing.JTextField();
        nights = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hotelName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pymtammt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        commissionPerc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        commissionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Call ID", "Sale ID", "Call timestamp", "Commission amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        commissionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commissionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(commissionTable);

        jLabel1.setText("Status");

        status_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a status", "Confirmed", "Paid out", "Canceled", "Deleted" }));
        status_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_comboActionPerformed(evt);
            }
        });

        jLabel2.setText("Date of call");

        jCheckBox1.setText("Prepaid");

        jLabel3.setText("Check in date");

        jLabel4.setText("Check out date");

        jLabel5.setText("Commission Earned");

        rooms.setEditable(false);

        nights.setEditable(false);
        nights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightsActionPerformed(evt);
            }
        });

        jLabel6.setText("Nights");

        jLabel7.setText("Hotel Name");

        jLabel8.setText("Cust. paid");

        jLabel9.setText("Commision perc");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateOfCall, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(checkOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(jCheckBox1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pymtammt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(nights, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(commissionPerc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dateOfCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(checkOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(commissionPerc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pymtammt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String selectedSaleID = "";
    boolean changedToCanceled = false;
    
    private void nightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nightsActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        
                DefaultTableModel tableModel = (DefaultTableModel) commissionTable.getModel();

      
 try {
            database.actions.connect();
            Connection connection  = database.actions.returnConn();

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM sales";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                                String saleID = resultSet.getString("sale_id");
                String datetime = resultSet.getString("call_date");
                int commissionAmount = resultSet.getInt("total_commission");
                String callID = resultSet.getString("call_id");

                

                tableModel.addRow(new Object[]{ callID,saleID, datetime, commissionAmount});
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void commissionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commissionTableMouseClicked
 sale s = new sale();

int index = commissionTable.getSelectedRow();

TableModel model = commissionTable.getModel();

String callID = model.getValueAt(index, 0).toString();

String saleID = model.getValueAt(index, 1).toString();
String timestamp = model.getValueAt(index, 2).toString();
String commissionAmount = model.getValueAt(index, 3).toString();

selectedSaleID = saleID;
        System.out.println(selectedSaleID);
                System.out.println(callID);
        System.out.println(saleID);



clear();


List<sale> saleList = business.getFromDatabase.sale(callID, saleID);
if (!saleList.isEmpty()) {
    sale sale = saleList.get(0);
    dateOfCall.setText(sale.getCallDate().toString());
    hotelName.setText(sale.getHotelName());
    
    checkInDate.setText(sale.getCheckInDate().toString());
    checkOutDate.setText(sale.getCheckOutDate().toString());
    commissionPerc.setText(Integer.toString(sale.getCommissionPercentage()));
    
    status_combo.setSelectedItem(sale.getCallStatus());
    
    
        long daysBetween = DateCalculator.calculateDaysBetween(sale.getCheckInDate(), sale.getCheckOutDate());

    System.out.println(daysBetween);
    
    
    
    nights.setText(Long.toString(daysBetween));
    pymtammt.setText(Integer.toString(sale.getTotalBill()));
    rooms.setText(Integer.toString(sale.getTotalCommission()));
} else {
    System.out.println("Error");
}
       

// TODO add your handling code here:
    }//GEN-LAST:event_commissionTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                String sql = "";
 if (status_combo.getEditor().getItem().toString().equals("Canceled") && (changedToCanceled = true)) {
     
       
                
 sql = "UPDATE sales SET call_status=\"" + status_combo.getEditor().getItem().toString() +
         "\", hotel_name=\"" + hotelName.getText().toString() + "\", total_bill=\"" + pymtammt.getText().toString()
        + "\", is_canceled_booking=1, canceled_date=\"" + dateFormat.format(currentDate)
        + "\" WHERE sale_id=\"" + selectedSaleID + "\";";            
        } else {
      sql = "UPDATE sales SET call_status=\"" + status_combo.getEditor().getItem().toString() +
         "\", hotel_name=\"" + hotelName.getText().toString() + "\", total_bill=\"" + pymtammt.getText().toString()
        + "\" WHERE sale_id=\"" + selectedSaleID + "\";";  
 }
     
        

            Connection cnn = database.actions.returnConn();

            Statement stmt2 = cnn.createStatement();
        stmt2.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = stmt2.getGeneratedKeys();
        
       
        
        
            
            UI_main.AddToOutputArea("Updated Successfully.");
        
        
    } catch (SQLException ex) {
        Logger.getLogger(addToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        UI_main.AddToOutputArea(ex.getMessage());
    }







        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void status_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_comboActionPerformed
        if (status_combo.getEditor().getItem().toString().equals("Canceled")) {
            changedToCanceled = true;
            System.out.println(changedToCanceled);
        } else {
            changedToCanceled = false;
                        System.out.println(changedToCanceled);

        }



        // TODO add your handling code here:
    }//GEN-LAST:event_status_comboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editCOmmissionEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCOmmissionEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCOmmissionEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCOmmissionEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCOmmissionEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkInDate;
    private javax.swing.JTextField checkOutDate;
    private javax.swing.JTextField commissionPerc;
    private javax.swing.JTable commissionTable;
    private javax.swing.JTextField dateOfCall;
    private javax.swing.JTextField hotelName;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nights;
    private javax.swing.JTextField pymtammt;
    private javax.swing.JTextField rooms;
    private javax.swing.JComboBox<String> status_combo;
    // End of variables declaration//GEN-END:variables
public void clear() {
    checkInDate.setText("");
    checkOutDate.setText("");
    commissionPerc.setText("");
    dateOfCall.setText("");
    hotelName.setText("");
    nights.setText("");
    pymtammt.setText("");
    rooms.setText("");
}
public static class DateCalculator {
    public static long calculateDaysBetween(LocalDate checkInDate, LocalDate checkOutDate) {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }
}

}