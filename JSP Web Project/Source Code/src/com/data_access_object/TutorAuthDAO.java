package com.data_access_object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorAuthDAO {
	
	Connection dbConnection = null;
	
	String DBURL = "jdbc:mysql://localhost:3306/webtech_finals";
	String DBUsername = "root";
	String DBPassword = "";
	
	String SQLStmt = "SELECT username, password FROM administrators WHERE username = ? AND password = ?";
	
	public Connection connectToDB() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(DBURL, DBUsername, DBPassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbConnection;
		
	}
	
	public void closeDBConnection() {
		
		try {
			
			if (dbConnection != null) {
				dbConnection.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkCredentials(String Username, String Password) {
		
		try {
			
			PreparedStatement pStmt = dbConnection.prepareStatement(SQLStmt);
			ResultSet tutorCredentials;
			
			pStmt.setString(1, Username);
			pStmt.setString(2, Password);
			
			tutorCredentials = pStmt.executeQuery();
			
			if (tutorCredentials.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
