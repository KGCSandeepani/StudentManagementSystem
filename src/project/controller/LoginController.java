/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import project.dbconnection.DBConnection;
import project.model.Login;

/**
 *
 * @author 
 */
public class LoginController {
    public static boolean loginToSystem(String userName, String password) throws ClassNotFoundException, SQLException{
        String sql = "Select Password From Login where User_name='"+userName+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            String passwordInDataBase=rst.getString(1);
            if (password.equals(passwordInDataBase)) {
                return true;
            } else {
                return false;
            }            
        } else {
            return false;
        }
    }
    
    public static boolean addPasswordAndUserName(Login login) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Login values(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, login.getPasswordId());
        stm.setObject(2, login.getUserName());
        stm.setObject(3, login.getPassword());        
        int res = stm.executeUpdate();
        return res > 0;
    }
    
    public static String searchPasswordId(String userName, String password) throws ClassNotFoundException, SQLException{
        String sql = "Select PasswordId From Login where User_name='"+userName+"' AND Password='"+password+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
              String passwordId=rst.getString(1);
              return passwordId;
        } else {
            return null;
        }
    }
    
    public static boolean deletePasswordAndUserName(String passwordId) throws ClassNotFoundException, SQLException {
        String sql = "Delete From Login where PasswordId='"+passwordId+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql) > 0;
    }
}
