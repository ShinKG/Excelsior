package com.data_access_object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.registration.StudentRegInfo;
import com.registration.TutorRegInfo;

public class RegistrationDAO {
	
	Connection dbConnection = null;
	
	String DBURL = "jdbc:mysql://localhost:3306/webtech_finals";
	String DBUsername = "root";
	String DBPassword = "";
	
	String StudentRegSQL = "INSERT INTO students "
						+ "(username, password, email, first_name, last_name, school, city, province, status) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	String TutorRegSQL = "INSERT INTO administrators "
						+ "(username, password, email, first_name, last_name, school, status) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	
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
	
	public void registerStudentInfo(StudentRegInfo studentRegInfo) {
		
		String Username = studentRegInfo.getUsername();
		String Password = studentRegInfo.getPassword();
		String Email = studentRegInfo.getEmail();
		String FirstName = studentRegInfo.getFristName();
		String LastName = studentRegInfo.getLastName();
		String School = studentRegInfo.getSchool();
		String City = studentRegInfo.getCity();
		String Province = studentRegInfo.getProvince();
		
		try {
			
			PreparedStatement pStmt = dbConnection.prepareStatement(StudentRegSQL);
			
			pStmt.setString(1, Username);
			pStmt.setString(2, Password);
			pStmt.setString(3, Email);
			pStmt.setString(4, FirstName);
			pStmt.setString(5, LastName);
			pStmt.setString(6, School);
			pStmt.setString(7, City);
			pStmt.setString(8, Province);
			pStmt.setString(9, "Activated");
			
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void registerTutorInfo(TutorRegInfo tutorRegInfo) {
		
		String Username = tutorRegInfo.getUsername();
		String Password = tutorRegInfo.getPassword();
		String Email = tutorRegInfo.getEmail();
		String FirstName = tutorRegInfo.getFristName();
		String LastName = tutorRegInfo.getLastName();
		String School = tutorRegInfo.getSchool();
		
		try {
			
			PreparedStatement pStmt = dbConnection.prepareStatement(TutorRegSQL);
			
			pStmt.setString(1, Username);
			pStmt.setString(2, Password);
			pStmt.setString(3, Email);
			pStmt.setString(4, FirstName);
			pStmt.setString(5, LastName);
			pStmt.setString(6, School);
			pStmt.setString(7, "Pending");
			
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
