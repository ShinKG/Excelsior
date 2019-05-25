package com.quizjsp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String DBURL = "jdbc:mysql://localhost/webtechfinals_jspquiz";
	private static String DBUsername = "root";
	private static String DBPassword = "";
	
	public static Connection createDBConnection() {
		
		Connection dbConnection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(DBURL, DBUsername, DBPassword);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("There was an SQL error connecting to the database.");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("There was an error connecting to the database.");
			
		}
		
		return dbConnection;
		
	}

}