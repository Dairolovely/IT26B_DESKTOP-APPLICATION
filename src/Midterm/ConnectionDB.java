package Midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    public static void main(String[] args){
        
    }
    private static final String URL = "jdbc:mysql://localhost:3306/it26b_dai";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        
     try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database is Connected Successfully!");
            
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
         
        }
     
     return conn;
     
    }
}

    