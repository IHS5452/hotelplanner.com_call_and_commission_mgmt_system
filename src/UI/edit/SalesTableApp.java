/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.edit;

/**
 *
 * @author ian-laptop
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SalesTableApp extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public SalesTableApp() {
        setTitle("Sales Table App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Datetime");
        tableModel.addColumn("Commission Amount");
        tableModel.addColumn("Call ID");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane);

        fetchSalesData();

        setVisible(true);
    }

    private void fetchSalesData() {
        try {
            database.actions.connect();
            Connection connection  = database.actions.returnConn();

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM sales";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String datetime = resultSet.getString("call_date");
                int commissionAmount = resultSet.getInt("total_commission");
                String callID = resultSet.getString("call_id");

                tableModel.addRow(new Object[]{datetime, commissionAmount, callID});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SalesTableApp());
    }
}
