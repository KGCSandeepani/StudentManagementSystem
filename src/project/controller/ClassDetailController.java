/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project.dbconnection.DBConnection;
import project.model.ClassDetail;

/**
 *
 * @author 
 */
public class ClassDetailController {
    public static ArrayList<ClassDetail> getAllClass() throws SQLException, ClassNotFoundException {
        String sql = "Select Subject_name,Name,Grade,CID,Day,Period From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ClassDetail> classDetailList = new ArrayList<>();
        while (rst.next()) {
            classDetailList.add(new ClassDetail(rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return classDetailList;
    }
    
    public static ArrayList<String> searchSubject() throws SQLException, ClassNotFoundException {
        String sql = "Select distinct Subject_name From Class c,Subject s where c.SUID=s.SUID";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> subjectList = new ArrayList<>();
        while (rst.next()) {
            subjectList.add(rst.getString(1));
        }
        return subjectList;
    }
    
    public static String searchSubjectBySEID(String sessionId) throws SQLException, ClassNotFoundException {
        String sql = "Select distinct Subject_name From Class c,Subject s,Session se where c.SUID=s.SUID AND c.CID=se.CID AND SEID='"+sessionId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            String subjectName = rst.getString(1);
            return subjectName;
        } else {
            return null;
        }
    }
    
    public static ClassDetail searchClassDetail(String CID) throws ClassNotFoundException, SQLException {
        String sql = "Select Subject_name,Name,Grade,CID,Day,Period From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID AND CID='"+CID+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            ClassDetail classDetail = new ClassDetail(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            return classDetail;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Integer> searchClassDetailBySubject(String subject) throws ClassNotFoundException, SQLException {
        String sql = "Select distinct Grade From Class c,Subject s,Grade g where c.SUID=s.SUID AND c.GID=g.GID AND Subject_name='"+subject+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Integer> classGradeList = new ArrayList<>();
        while (rst.next()) {
            classGradeList.add(rst.getInt(1));
        }
        return classGradeList;
    }
    
    public static ArrayList<String> searchClassDetailBySubjectGrade(String subject, String grade) throws ClassNotFoundException, SQLException {
        String sql = "Select distinct Name From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID AND Subject_name='"+subject+"' AND Grade='"+grade+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> teachersList = new ArrayList<>();
        while (rst.next()) {
            teachersList.add(rst.getString(1));
        }
        return teachersList;
    }
    
    public static ArrayList<String> searchClassDetailBySubjectGradeTeacher(String subject, String grade, String teacher) throws ClassNotFoundException, SQLException {
        String sql = "Select Day From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID AND Subject_name='"+subject+"' AND Grade='"+grade+"' AND Name='"+teacher+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> dayList = new ArrayList<>();
        while (rst.next()) {
            dayList.add(rst.getString(1));
        }
        return dayList;
    }
    
    public static ArrayList<String> searchClassDetailBySubjectGradeTeacherDay(String subject, String grade, String teacher, String day) throws ClassNotFoundException, SQLException {
        String sql = "Select Period From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID AND Subject_name='"+subject+"' AND Grade='"+grade+"' AND Name='"+teacher+"' AND Day='"+day+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> periodList = new ArrayList<>();
        while (rst.next()) {
            periodList.add(rst.getString(1));
        }
        return periodList;
    }
    
    public static String searchClassDetailBySubjectGradeTeacherDayPeriod(String subject, String grade, String teacher,String day,String period) throws ClassNotFoundException, SQLException {
        String sql = "Select CID From Class c,Subject s,Teacher t,Grade g where c.SUID=s.SUID AND c.TID=t.TID AND c.GID=g.GID AND Subject_name='"+subject+"' AND Grade='"+grade+"' AND Name='"+teacher+"' AND Day='"+day+"' AND Period='"+period+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            String classId = rst.getString("CID");
            return classId;
        } else {
            return null;
        }
    }
}
