package com.example.model.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnection {
	private Connection connection;
	private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3305/finace_tracker";
    
    private DBConnection() throws  SQLException{
        try {
            Class.forName(DBConnection.JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DBConnection.DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load database driver: " + e.getMessage());
        }
    }
    

    public Connection getConnection() {
        return this.connection;	
    }
    
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.err.println("Problem closing connection.");
        }
    }
}
