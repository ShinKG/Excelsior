package com.quizjsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizjsp.model.DBConnection;

// Code Testing Imports:
import java.sql.ResultSetMetaData;

@WebServlet("/StartQuiz")
public class StartQuiz extends HttpServlet {
	
	String SQL = "SELECT * FROM questions WHERE topic = ? LIMIT ?";
	String QuizTopic = "";
	int numberOfQuestions = 0;
	
	Connection dbConnection = null;
	ResultSet questionSet = null;
	
	RequestDispatcher requestDispatcher;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dbConnection = DBConnection.createDBConnection();
		
		QuizTopic = request.getParameter("quizTopic");
		numberOfQuestions = Integer.parseInt(request.getParameter("numOfQuestions"));
		
		try {
			PreparedStatement pStmt = dbConnection.prepareStatement(SQL);
			
			pStmt.setString(1, QuizTopic);
			pStmt.setInt(2, numberOfQuestions);
			
			questionSet = pStmt.executeQuery();
			
			// Print Question Result Set
			// Start of Snippet
			ResultSetMetaData rsmd = questionSet.getMetaData();
			int columnsNum = rsmd.getColumnCount();
			
			while (questionSet.next()) {
				for (int i = 1; i <= columnsNum; i++) {
					if (i > 1) System.out.print(", ");
					String ColumnValue = questionSet.getString(i);
					System.out.print(ColumnValue);
				}
				System.out.println("");
			}
			// End of Snippet
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			if (dbConnection != null) {
				dbConnection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("There was an SQL error closing the connection to the database.");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("There was an error closing the connection to the database.");
			
		}
		
		requestDispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
