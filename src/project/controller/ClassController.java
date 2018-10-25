/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Classes;
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
public class ClassController {
    public static boolean addClass(Classes classes) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Class values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, classes.getSUID());
        stm.setObject(2, classes.getTID());
        stm.setObject(3, classes.getGID());
        stm.setObject(4, classes.getCID());
        stm.setObject(5, classes.getDay());  
        stm.setObject(6, classes.getPeriod());  
        int res = stm.executeUpdate();
        return res > 0;
    }

//    public static Classes searchClass(String CID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Class where CID='"+CID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Classes classes = new Classes(CID, rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
//            return classes;
//        } else {
//            return null;
//        }
//    }
    
    public static ArrayList<Classes> searchClassByTID(String TID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Class where TID='"+TID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Classes> classList = new ArrayList<>();
        while (rst.next()) {
            classList.add(new Classes(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return classList;
    }
    
//    public static ArrayList<Classes> searchClassBySUID(String SUID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Class where SUID='"+SUID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Classes> classList = new ArrayList<>();
//        while (rst.next()) {
//            classList.add(new Classes(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
//        }
//        return classList;
//    }
    
//    public static ArrayList<Classes> searchClassBySuidGid(String SUID, String GID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Class where SUID='"+SUID+"' AND GID='"+GID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Classes> classList = new ArrayList<>();
//        while (rst.next()) {
//            classList.add(new Classes(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
//        }
//        return classList;
//    }
    
//    public static ArrayList<Classes> searchClassBySuidGidTid(String SUID, String GID, String TID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Class where SUID='"+SUID+"' AND GID='"+GID+"' AND TID='"+TID+"'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Classes> classList = new ArrayList<>();
//        while (rst.next()) {
//            classList.add(new Classes(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
//        }
//        return classList;
//    }
    
    public static boolean deleteClass(String CID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Class where CID='"+CID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static boolean updateClass(Classes classes) throws ClassNotFoundException, SQLException {
        String sql = "Update Class set SUID=?, TID=?, GID=?, Day=?, Period=? where CID=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(6, classes.getCID());
        stm.setObject(1, classes.getSUID());
        stm.setObject(2, classes.getTID());
        stm.setObject(3, classes.getGID());
        stm.setObject(4, classes.getDay());
        stm.setObject(5, classes.getPeriod());
        int res = stm.executeUpdate();
        return res > 0;
    }

//    public static ArrayList<Classes> viewClass() throws SQLException, ClassNotFoundException {
//        String sql = "Select * From Class";
//        Connection connection = DBConnection.getDBConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Classes> classList = new ArrayList<>();
//        while (rst.next()) {
//            classList.add(new Classes(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
//        }
//        return classList;
//    }
    


}


