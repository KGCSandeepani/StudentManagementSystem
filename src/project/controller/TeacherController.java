/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Teacher;
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
public class TeacherController {
    public static boolean addTeacher(Teacher t) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Teacher values(?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, t.getTID());
        stm.setObject(2, t.getName());
        stm.setObject(3, t.getAddress());
        stm.setObject(4, t.getNIC());
        stm.setObject(5, t.getTeleNo());
        int res = stm.executeUpdate();
        return res > 0;
    }

//    public static Teacher searchTeacher(String TID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Teacher where TID='"+TID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Teacher c1 = new Teacher(TID, rst.getString(2), rst.getString(3), rst.getString(4),rst.getInt(5));
//            return c1;
//        } else {
//            return null;
//        }
//    }
    
    public static Teacher searchTeacherByName(String name) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Teacher where Name like'"+name+"%'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Teacher c1 = new Teacher(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getInt(5));
            return c1;
        } else {
            return null;
        }
    }
    
    public static Teacher searchTeacherId(String teacherName) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Teacher where Name='"+teacherName+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Teacher c1 = new Teacher(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getInt(5));
            return c1;
        } else {
            return null;
        }
    }
    
    public static boolean deleteTeacher(String TID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Teacher where TID='"+TID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static boolean updateTeacher(Teacher t) throws ClassNotFoundException, SQLException {
        String sql = "Update Teacher set Name=?, Address=?, NIC=?, Tele_no=? where TID=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(5, t.getTID());
        stm.setObject(1, t.getName());
        stm.setObject(2, t.getAddress());
        stm.setObject(3, t.getNIC());
        stm.setObject(4, t.getTeleNo());
        int res = stm.executeUpdate();
        return res > 0;
    }

    public static ArrayList<Teacher> viewTeacher() throws SQLException, ClassNotFoundException {
        String sql = "Select * from Teacher";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Teacher> teacherList = new ArrayList<>();
        while (rst.next()) {
            teacherList.add(new Teacher(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4), rst.getInt(5)));
        }
        return teacherList;
    }
}
