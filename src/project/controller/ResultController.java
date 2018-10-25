/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Result;
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
public class ResultController {
    public static boolean addResult(ArrayList<Result> resultList) throws ClassNotFoundException, SQLException {        
        Connection connection = DBConnection.getDBConnection().getConnection();
        for (Result result : resultList) {
            String sql = "Insert into Result values(?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, result.getSEID());
            stm.setObject(2, result.getEID());
            stm.setObject(3, result.getREID()); 
            stm.setObject(4, result.getMark());
            stm.setObject(5, result.getState()); 
            if (stm.executeUpdate() <= 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean addNewResult(Result result) throws ClassNotFoundException, SQLException {        
        Connection connection = DBConnection.getDBConnection().getConnection();        
        String sql = "Insert into Result values(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, result.getSEID());
        stm.setObject(2, result.getEID());
        stm.setObject(3, result.getREID()); 
        stm.setObject(4, result.getMark());
        stm.setObject(5, result.getState());       
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<Result> searchResult(String EID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Result where EID='"+EID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Result> resultList = new ArrayList<>();
        while (rst.next()) {
            resultList.add(new Result(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return resultList;
    }
    
    public static boolean deleteResult(String REID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Result where REID='"+REID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

//    public static boolean updateResult(Result r) throws ClassNotFoundException, SQLException {
//        String sql = "Update Result set SEID=?, EID=?, Mark=?, State=? where REID=?";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(5, r.getREID());
//        stm.setObject(1, r.getSEID());
//        stm.setObject(2, r.getEID());
//        stm.setObject(3, r.getMark());
//        stm.setObject(4, r.getState());
//        int res = stm.executeUpdate();
//        return res > 0;
//    }

    public static ArrayList<Result> viewResult(String SEID) throws SQLException, ClassNotFoundException {
        String sql = "Select * From Result where SEID='"+SEID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Result> resultList = new ArrayList<>();
        while (rst.next()) {
            resultList.add(new Result(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return resultList;
    }
}
