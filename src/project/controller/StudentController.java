/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project.model.Session;

/**
 *
 * @author Chamodi Sandeepani
 */
public class StudentController {
    public static boolean addStudent(Student s, ArrayList<Session> sessions) throws ClassNotFoundException, SQLException {        
        Connection connection = DBConnection.getDBConnection().getConnection();
        try{
            connection.setAutoCommit(false);
            String sql = "Insert into Student values(?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, s.getSID());
            stm.setObject(2, s.getName());
            stm.setObject(3, s.getAddress());
            stm.setObject(4, s.getTele_no());  
            stm.setObject(5, s.getRegister_date());  
            stm.setObject(6, s.getRegister_fee());             
            boolean isAddStudent= stm.executeUpdate() > 0;
            if (isAddStudent) {
                boolean isAddSession=SessionController.addSessionList(sessions);
                if (isAddSession) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                }
            }
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
        
    }

    public static Student searchStudent(String SID) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Student where SID='"+SID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Student s = new Student(SID, rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getDouble(6));
            return s;
        } else {
            return null;
        }
    }
    
    public static Student searchStudentByName(String name) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Student where Name like '"+name+"%'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Student s = new Student(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getDouble(6));
            return s;
        } else {
            return null;
        }
    }

    public static boolean deleteStudent(String SID) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Student where SID='"+SID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static boolean updateStudent(Student s) throws ClassNotFoundException, SQLException {
        String sql = "Update Student set Name=?, Address=?, Tele_no=?, Register_date=?, Register_fee=? where SID=?";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(6, s.getSID());
        stm.setObject(1, s.getName());
        stm.setObject(2, s.getAddress());
        stm.setObject(3, s.getTele_no());
        stm.setObject(4, s.getRegister_date());
        stm.setObject(5, s.getRegister_fee());
        int res = stm.executeUpdate();
        return res > 0;
    }

    public static ArrayList<Student> viewStudent() throws SQLException, ClassNotFoundException {
        String sql = "Select * from Student";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            studentList.add(new Student(rst.getString(1), rst.getString(2), rst.getString(3),rst.getInt(4),rst.getString(5), rst.getDouble(6)));
        }
        return studentList;
    }
    
    
}
