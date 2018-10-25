/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Session;
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
public class SessionController {
    public static boolean addSession(Session session) throws ClassNotFoundException, SQLException {        
        Connection connection = DBConnection.getDBConnection().getConnection();        
        String sql = "Insert into Session values(?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, session.getSID());
        stm.setObject(2, session.getCID());
        stm.setObject(3, session.getSEID());        
        int res = stm.executeUpdate();                
        return res>0;
    }
    
    public static boolean addSessionList(ArrayList<Session> sessions) throws ClassNotFoundException, SQLException {        
        Connection connection = DBConnection.getDBConnection().getConnection();        
        for (Session session : sessions) {
            String sql = "Insert into Session values(?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, session.getSID());
            stm.setObject(2, session.getCID());
            stm.setObject(3, session.getSEID());        
            if (stm.executeUpdate()<=0) {
                return false;
            }            
        }
        return true;
    }

    public static Session searchSession(String SID,String CID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Session where SID='"+SID+"' AND CID='"+CID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Session s = new Session( SID, CID ,rst.getString(3));
            return s;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Session> searchSessionFromCID(String CID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Session where CID='"+CID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Session> sessionList = new ArrayList<>();
        while (rst.next()) {
            sessionList.add(new Session(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return sessionList;
    }
    
    public static ArrayList<Session> searchSessionFromSID(String SID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Session where SID='"+SID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Session> sessionList = new ArrayList<>();
        while (rst.next()) {
            sessionList.add(new Session(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return sessionList;
    }
    
    public static Session searchSessionFromSEID(String SEID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Session where SEID='"+SEID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Session s = new Session( rst.getString(1), rst.getString(2) ,rst.getString(3));
            return s;
        } else {
            return null;
        }
    }

    public static boolean deleteSession(String SEID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Session where SEID='"+SEID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

//    public static boolean updateSession(Session s) throws ClassNotFoundException, SQLException {
//        String sql = "Update Session set SID=?, CID=? where SEID=?";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(3, s.getSEID());
//        stm.setObject(1, s.getSID());
//        stm.setObject(2, s.getCID());
//        int res = stm.executeUpdate();
//        return res > 0;
//    }

//    public static ArrayList<Session> viewSession() throws SQLException, ClassNotFoundException {
//        String sql = "Select * from Session";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Session> sessionList = new ArrayList<>();
//        while (rst.next()) {
//            sessionList.add(new Session(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return sessionList;
//    }
}
