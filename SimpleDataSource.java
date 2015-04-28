package com.mycompany.programmingproject;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.io.FileInputStream;
import java.io.IOException; 
import java.io.FileInputStream;
import java.util.Properties;
/*
* A simple data source for getting database connections. 
 */
public class SimpleDataSource 
 { 
    private static String url; 
    private static String username; 
    private static String password; 
    
    public static void init() throws IOException, ClassNotFoundException 
    {        
        String driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/group_test";
        username = "root";
        
        if (username == null) { username = ""; }
        password = "m477d3rbyone23";
        
        if (password == null) { password = ""; } 
        
        if (driver != null) { Class.forName(driver); } 
    }
    
    /** Gets a connection to the database. 
     * @return the database connection 
     * @throws java.sql.SQLException */ 
    
    public static Connection getConnection() throws SQLException 
    { 
        return DriverManager.getConnection(url, username, password);
    } 

    
}
