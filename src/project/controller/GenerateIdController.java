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
import project.dbconnection.DBConnection;

/**
 *
 * @author 
 */
public class GenerateIdController {
    public static String lastTableId(String idName,String table) throws ClassNotFoundException, SQLException{
        String sql="Select "+idName+" From "+table+" order by 1 desc limit 1";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        String tableId=null;
        while (rst.next()) {            
            tableId=rst.getString(1);
        }
        return tableId;
    }
}
