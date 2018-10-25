/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Attendance;
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
public class AttendanceController {
    public static boolean addAttendance(Attendance a) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Attendance values(?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, a.getSEID());
        stm.setObject(2, a.getAID());
        stm.setObject(3, a.getDate());        
        int res = stm.executeUpdate();
        return res > 0;
    }

//    public static Attendance searchAttendance(String AID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Attendance where AID='"+AID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Attendance a = new Attendance( rst.getString(1), AID, rst.getString(3));
//            return a;
//        } else {
//            return null;
//        }
//    }

//    public static boolean deleteAttendance(String AID) throws ClassNotFoundException, SQLException {
//        String sql = "Delete From Attendance where AID='"+AID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        return stm.executeUpdate(sql) > 0;
//    }

//    public static boolean updateAttendance(Attendance a) throws ClassNotFoundException, SQLException {
//        String sql = "Update Attendance set SEID=?, Date=? where AID=?";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(3, a.getAID());
//        stm.setObject(1, a.getSEID());
//        stm.setObject(2, a.getDate());
//        int res = stm.executeUpdate();
//        return res > 0;
//    }

    public static ArrayList<Attendance> viewAttendanceOfSEID(String SEID) throws SQLException, ClassNotFoundException {
        String sql = "Select * from Attendance where SEID='"+SEID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Attendance> attendanceList = new ArrayList<>();
        while (rst.next()) {
            attendanceList.add(new Attendance(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return attendanceList;
    }
}
