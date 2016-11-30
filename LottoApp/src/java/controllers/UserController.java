/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DBConnection;
import database.DBHandle;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Heshan
 */
public class UserController {
    public static boolean checkPassword(String userName,String password) throws ClassNotFoundException, SQLException {
        String sql="select USER_NAME from user where PASSWORD=? and USER_NAME=?";
        Object[] data=new Object[]{password,userName};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), sql,data );
        if(resultSet.next()){
            return true;
        }else{
            return false;
        }
    }
}
