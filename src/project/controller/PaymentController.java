/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Chamodi Sandeepani
 */
public class PaymentController {
    public static boolean addPayment(Payment p) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Payment values(?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, p.getSEID());
        stm.setObject(2, p.getPID());
        stm.setObject(3, p.getFee()); 
        stm.setObject(4, p.getDate()); 
        int res = stm.executeUpdate();
        return res > 0;
    }

//    public static Payment searchPayment(String PID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Payment where PID='"+PID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Payment p = new Payment( rst.getString(1), PID, rst.getDouble(3), rst.getString(4));
//            return p;
//        } else {
//            return null;
//        }
//    }
    
//    public static boolean deletePayment(String PID) throws ClassNotFoundException, SQLException {
//        String sql = "Delete From Payment where PID='"+PID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        return stm.executeUpdate(sql) > 0;
//    }

//    public static boolean updatePayment(Payment p) throws ClassNotFoundException, SQLException {
//        String sql = "Update Payment set SEID=?, Fee=?, Date=? where PID=?";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(4, p.getPID());
//        stm.setObject(1, p.getSEID());
//        stm.setObject(2, p.getFee());
//        stm.setObject(3, p.getDate());
//        int res = stm.executeUpdate();
//        return res > 0;
//    }

    public static ArrayList<Payment> viewPayment(String SEID) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Payment where SEID='"+SEID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Payment> paymentList = new ArrayList<>();
        while (rst.next()) {
            paymentList.add(new Payment(SEID, rst.getString(2), rst.getDouble(3), rst.getString(4)));
        }
        return paymentList;
    }
}
