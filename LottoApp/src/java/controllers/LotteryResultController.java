/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.DBConnection;
import database.DBHandle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LotteryResult;

/**
 *
 * @author Heshan
 */
public class LotteryResultController {
    
    public static Boolean addLotteryResult(LotteryResult lotteryResult) throws ClassNotFoundException, SQLException {
        Connection connection=null;
        try{
            connection=DBConnection.getConnectionToDB();
            connection.setAutoCommit(false);
            String quary ="INSERT INTO lot_results_history(LOT_ID,DRAW_NO,DATE,NO1,NO2,NO3,NO4,NO5,NO6,BONUS_FACTOR1,BONUS_FACTOR2,BONUS_FACTOR3) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            Object []data={lotteryResult.getLotteryId(),lotteryResult.getDrawNo(),lotteryResult.getDate(),lotteryResult.getNo1(),lotteryResult.getNo2(),lotteryResult.getNo3(),lotteryResult.getNo4(),lotteryResult.getNo5(),lotteryResult.getNo6(),lotteryResult.getBonusFactor1(),lotteryResult.getBonusFactor2(),lotteryResult.getBonusFactor3()};
            
            Boolean res=  DBHandle.setData(DBConnection.getConnectionToDB(), quary, data);

            if(res){
                connection.commit();
                return true;
            }else{
                connection.rollback();
                return false;
            }
        }catch(SQLException ex){
            connection.rollback();
            throw ex;
        }finally{
            if(connection!=null){
                connection.setAutoCommit(true);
            }
        }
    }
    
    public static List<LotteryResult> getLotteryResultsByDate(String date) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM lot_results_history WHERE DATE=? ";
        Object[] data = new Object[]{date};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        List<LotteryResult> resultList = new ArrayList<LotteryResult>();
        while (resultSet.next()) {
            LotteryResult lotteryResult = new LotteryResult(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),resultSet.getString(9),resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13));
            resultList.add(lotteryResult);
        }
        return resultList;
    }
    
    //SELECT l.AUTH_CODE,l.LOT_ID,l.AUTHORITY FROM lottery l , lottery_date ld WHERE l.LOT_ID = ld.LOT_ID AND ld.DAY=5 GROUP BY l.LOT_ID;
    public static List<String[]> getLotteries(String dayNo) throws SQLException, ClassNotFoundException {
        String query = "SELECT l.AUTH_CODE,l.LOT_ID,l.AUTHORITY,l.NAME FROM lottery l , lottery_date ld WHERE l.LOT_ID = ld.LOT_ID AND ld.DAY=? GROUP BY l.LOT_ID;";
        Object[] data = new Object[]{dayNo};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);
        
        List<String[]> resultList = new ArrayList<String[]>();
        while (resultSet.next()) {
            String[] lottery = {resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)};  
            resultList.add(lottery);
        }
        return resultList;
    }
    
    
    public static int getLastDrawNo(String lotId) throws SQLException, ClassNotFoundException {
        String query = "SELECT DRAW_NO FROM lot_results_history WHERE LOT_ID=? ORDER BY DRAW_NO DESC";
        Object[] data = new Object[]{lotId};
        ResultSet resultSet = DBHandle.getData(DBConnection.getConnectionToDB(), query, data);

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }
    
}
