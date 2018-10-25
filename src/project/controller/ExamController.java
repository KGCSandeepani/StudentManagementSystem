/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project.model.Result;

/**
 *
 * @author Chamodi Sandeepani
 */
public class ExamController {
    public static boolean addExam(Exam e, ArrayList<Result> resultList) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        try{
            connection.setAutoCommit(false);
            String sql = "Insert into Exam values(?,?,?)";        
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, e.getEID());
            stm.setObject(2, e.getExam_name());
            stm.setObject(3, e.getDate()); 
            boolean isAddExam = stm.executeUpdate()>0;
            if(isAddExam) {
                boolean isAddResult=ResultController.addResult(resultList);
                if (isAddResult) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                }
            }
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
        
    }

    public static Exam searchExam(String EID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Exam where EID='"+EID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Exam e = new Exam(EID, rst.getString(2), rst.getString(3));
            return e;
        } else {
            return null;
        }
    }
    
    public static Exam searchExamByExamName(String examName) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Exam where Exam_name like '"+examName+"%'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Exam e = new Exam(rst.getString(1), rst.getString(2), rst.getString(3));
            return e;
        } else {
            return null;
        }
    }
    
//    public static ArrayList<Exam> searchExamFromYear(int year) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Exam where year(Date)="+year;
//        Connection connection = DBConnection.getDBConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        ArrayList<Exam> examList = new ArrayList<>();
//        while (rst.next()) {
//            examList.add(new Exam(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return examList;
//    }

    public static boolean deleteExam(String EID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Exam where EID='"+EID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static boolean updateExam(Exam e) throws ClassNotFoundException, SQLException {
        String sql = "Update Exam set Exam_name=?, Date=? where EID=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(3, e.getEID());
        stm.setObject(1, e.getExam_name());
        stm.setObject(2, e.getDate());
        int res = stm.executeUpdate();
        return res > 0;
    }

    public static ArrayList<Exam> viewExam() throws SQLException, ClassNotFoundException {
        String sql = "Select * from Exam";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Exam> examList = new ArrayList<>();
        while (rst.next()) {
            examList.add(new Exam(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return examList;
    }
    
}
