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
import java.util.ArrayList;
import java.util.List;
import models.Lottery;
import models.LotteryResult;

/**
 *
 * @author Heshan
 */
public class LotteryController {
    
    public static Lottery getLottery(String authCode) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM lottery WHERE AUTH_CODE=? ";
        Object[] data = new Object[]{authCode};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);

        if (resultSet.next()) {
            Lottery lottery = new Lottery(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getBoolean(5),resultSet.getBoolean(6),resultSet.getBoolean(7),resultSet.getString(8),resultSet.getString(9));
            return lottery;
        }
        return null;
    }
    
}
