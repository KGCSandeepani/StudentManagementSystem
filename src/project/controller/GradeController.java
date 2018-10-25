/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import project.dbconnection.DBConnection;
import project.model.Grade;
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
public class GradeController {
    public static boolean addGrade(Grade g) throws ClassNotFoundException, SQLException{
        String sql="Insert into Grade values(?,?)";
        Connection connection=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, g.getGID());
        stm.setObject(2, g.getGrade());
        int res=stm.executeUpdate();
        return res>0;
    }
    public static boolean deleteGrade(String GID) throws ClassNotFoundException, SQLException{
        String sql="Delete From Grade where GID='"+GID+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate(sql);
        return res>0;
    }
//    public static Grade searchGradeByGID(String GID) throws ClassNotFoundException, SQLException {
//        String sql = "Select * From Grade where GID='" + GID + "'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            Grade g = new Grade(GID, rst.getInt("Grade"));
//            return g;
//        } else {
//            return null;
//        }
//    }
    
    public static Grade searchGrade(int Grade) throws ClassNotFoundException, SQLException {
        String sql = "Select * From Grade where Grade='" + Grade + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Grade g = new Grade(rst.getString(1), rst.getInt(2));
            return g;
        } else {
            return null;
        }
    }
//    public static boolean updateGrade(Grade g) throws ClassNotFoundException, SQLException {
//        String sql = "Update Grade set Grade='"+g.getGrade()+" where GID='"+g.getGID();
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        int res = stm.executeUpdate(sql);
//        return res>0;
//    }

    public static ArrayList<Grade> viewGrade() throws SQLException, ClassNotFoundException {
        String sql = "Select * from Grade";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Grade> gradeList = new ArrayList<>();
        while (rst.next()) {
            gradeList.add(new Grade(rst.getString(1), rst.getInt(2)));
        }
        return gradeList;
    }
}
