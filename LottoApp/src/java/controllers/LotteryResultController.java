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
            String quary ="INSERT INTO lot_results_history VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Object []data={lotteryResult.getHistoryId(),lotteryResult.getLotteryId(),lotteryResult.getDrawNo(),lotteryResult.getNo1(),lotteryResult.getNo2(),lotteryResult.getNo3(),lotteryResult.getNo4(),lotteryResult.getNo5(),lotteryResult.getNo6(),lotteryResult.getBonusNo(),lotteryResult.getBonusLetter(),lotteryResult.getBonusFactor1(),lotteryResult.getBonusFactor2()};
            
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
            LotteryResult lotteryResult = new LotteryResult(resultSet.getInt("1"), resultSet.getInt("2"), resultSet.getInt("3"), resultSet.getString("4"),resultSet.getInt("5"),resultSet.getInt("6"), resultSet.getInt("7"), resultSet.getInt("8"),resultSet.getInt("9"),resultSet.getInt("10"), resultSet.getInt("11"), resultSet.getString("12"), resultSet.getString("13"), resultSet.getString("14"));
            resultList.add(lotteryResult);
        }
        return resultList;
    }
}
