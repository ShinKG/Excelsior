package com.quizjsp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quizjsp.model.QuestionInfo;
//Code Testing Imports:
import java.sql.ResultSetMetaData;

public class QuizDAO {
	
	Connection dbConnection = null;
	private static String DBURL = "jdbc:mysql://localhost/webtechfinals_jspquiz";
	private static String DBUsername = "root";
	private static String DBPassword = "";
	
	String SQLQuestionList = "SELECT * FROM questions WHERE topic = ? ORDER BY RAND() LIMIT ?";
	String SQLRecordResult = "INSERT INTO results (topic, score, total_score, evaluation) VALUES (?, ?, ?, ?)";
	String SQLRetrieveResult = "SELECT * FROM results WHERE ";
	
	public Connection createDBConnection() {
		
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
	
	public void closeDBConnection() {
		
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
		
	}
	
	public List<QuestionInfo> getQuestionList(Connection dbConnection, String QuizTopic, int numberOfQuestions) throws SQLException {
		
		List<QuestionInfo> questionList = new ArrayList<QuestionInfo>();
		
		try {
			
			PreparedStatement pStmt = dbConnection.prepareStatement(SQLQuestionList);
			ResultSet questionSet;
			
			pStmt.setString(1, QuizTopic);
			pStmt.setInt(2, numberOfQuestions);
			
			questionSet = pStmt.executeQuery();
			
			// Print Question Result Set
			// Start of Snippet
			
			/**
			ResultSetMetaData rsmd = questionSet.getMetaData();
			int columnsNum = rsmd.getColumnCount();
			
			while (questionSet.next()) {
				for (int i = 1; i <= columnsNum; i++) {
					if (i > 1) System.out.print(", ");
					String ColumnValue = questionSet.getString(i);
					System.out.print(ColumnValue);
			/	}
				System.out.println("");
			}
			**/
			
			// End of Snippet
			
			while (questionSet.next()) {
				
				QuestionInfo question = new QuestionInfo();
				question.setQuestionID(questionSet.getInt("question_id"));
				question.setTopic(questionSet.getString("topic"));
				question.setQuestion(questionSet.getString("question"));
				question.setOptionA(questionSet.getString("option_a"));
				question.setOptionB(questionSet.getString("option_b"));
				question.setOptionC(questionSet.getString("option_c"));
				question.setOptionD(questionSet.getString("option_d"));
				question.setOptionE(questionSet.getString("option_e"));
				question.setAnswer(questionSet.getString("answer"));
				questionList.add(question);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questionList;
		
	}
	
	public void recordResult(Connection dbConnection, String QuizTopic, int score, int totalScore) {
		
		int passingGrade = 0;
		String Evaluation = "FAIL";
		
		passingGrade = (totalScore / 2) + 1;
		
		if (score >= passingGrade) {
			Evaluation = "PASS";
		}
		
		try {
			PreparedStatement pStmt = dbConnection.prepareStatement(SQLRecordResult);
			
			pStmt.setString(1, QuizTopic);
			pStmt.setInt(2, score);
			pStmt.setInt(3, totalScore);
			pStmt.setString(4, Evaluation);
			
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}