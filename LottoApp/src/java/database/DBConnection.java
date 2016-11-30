package database;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Geniuez
 * 
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/lottoappdb","root","12345");

    }

    private Connection getConnection(){
        return connection;
    }

    private static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

    public static Connection getConnectionToDB() throws ClassNotFoundException, SQLException{
        DBConnection dbConnect=DBConnection.getDBConnection();
        return dbConnect.getConnection();

    }
}
