/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Subject;
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
public class SubjectController {
    public static boolean addSubject(Subject s) throws ClassNotFoundException, SQLException{ 
        String sql="Insert into Subject values(?,?)";
        Connection connection=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, s.getSUID());  
        stm.setObject(2, s.getSubjctName());
        int res=stm.executeUpdate();
        return res>0;
    }
    
    public static boolean deleteSubject(String SUID) throws ClassNotFoundException, SQLException{
        String sql="Delete From Subject where SUID='"+SUID+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate(sql);
        return res>0;
    }
    
    public static boolean updateSubject(Subject subject) throws ClassNotFoundException, SQLException{
        String sql="Update Subject set Subject_name='"+subject.getSubjctName()+"' where SUID='"+subject.getSUID()+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate(sql);
        return res>0;
    }
    
//    public static Subject searchSubject(String SUID) throws ClassNotFoundException, SQLException{
//        String sql="Select * From Subject where SUID='"+SUID+"'";
//        Connection conn=DBConnection.getDBConnection().getConnection();
//        Statement stm=conn.createStatement();
//        ResultSet res=stm.executeQuery(sql);
//        if (res.next()) {
//            Subject s=new Subject(SUID, res.getString("Subject_name"));
//            return s;
//        } else {
//            return null;
//        }        
//    }
    
    public static Subject searchSubjectBySubjectName(String subjectName) throws ClassNotFoundException, SQLException{
        String sql="Select * From Subject where Subject_name like'"+subjectName+"%'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet res=stm.executeQuery(sql);
        if (res.next()) {
            Subject s=new Subject(res.getString(1), res.getString(2));
            return s;
        } else {
            return null;
        }       
    }
    
    public static Subject searchSubjectId(String subjectName) throws ClassNotFoundException, SQLException{
        String sql="Select * From Subject where Subject_name='"+subjectName+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet res=stm.executeQuery(sql);
        if (res.next()) {
            Subject s=new Subject(res.getString(1), res.getString(2));
            return s;
        } else {
            return null;
        }        
    }
    
    public static ArrayList<Subject> viewSubject() throws ClassNotFoundException, SQLException{
        String sql="Select * from Subject";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet res=stm.executeQuery(sql);
        ArrayList<Subject>subjectList=new ArrayList<>();
        while (res.next()) {            
            subjectList.add(new Subject(res.getString(1), res.getString(2)));
        }
        return subjectList;
    }
}
