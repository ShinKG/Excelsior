package com.quizjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizjsp.model.QuizDAO;

@WebServlet("/FinishQuiz")
public class FinishQuiz extends HttpServlet {
	
	QuizDAO quizDAO = new QuizDAO();
	RequestDispatcher requestDispatcher;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession quizSession = request.getSession();
		
		String UserAnswer = "";
		String KeyAnswer = "";
		String QuizTopic = "";
		int totalScore = 0;
		int userScore = 0;
		
		QuizTopic = (String) quizSession.getAttribute("topic");
		totalScore = Integer.parseInt(request.getParameter("questionCtr"));
		
		System.out.println(QuizTopic);
		
		for (int i = 1; i <= totalScore; i++) {
			
			if (request.getParameter("option"+i) != null) {
				
				UserAnswer = request.getParameter("option"+i);
				KeyAnswer = request.getParameter("answer"+i);
				
				System.out.println("User's Answer: "+UserAnswer);
				System.out.println("Key Answer: "+KeyAnswer);
					
				if (UserAnswer.equals(KeyAnswer)) {
					userScore++;
				}
				
			}
			
		}
		
		int passingScore = 0;
		String Evaluation = "FAIL";
		
		switch (totalScore) {
			case 1: case 2:
				passingScore = 1;
				break;
			case 3:	case 4:
				passingScore = 2;
				break;
			case 5:	case 6:
				passingScore = 3;
				break;
			case 7:	case 8:		
				passingScore = 4;
				break;
			case 9: case 10:
				passingScore = 5;
				break;
			case 11: case 12:
				passingScore = 6;
				break;
			case 13: case 14:
				passingScore = 7;
				break;
			case 15:
				passingScore = 8;
				break;
		}
		
		if (userScore >= passingScore) {
			Evaluation = "PASS";
		}
		
		/**
		try {
			quizDAO.recordResult(quizDAO.createDBConnection(), QuizTopic, userScore, questionCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		**/
		
		quizSession.setAttribute("user_score", userScore);
		quizSession.setAttribute("total_score", totalScore);
		quizSession.setAttribute("evaluation", Evaluation);
		
		System.out.println("Quiz Topic: "+QuizTopic);
		System.out.println("Passing Grade: "+passingScore);
		System.out.println("Question Count: "+totalScore);
		System.out.println("User Score: "+userScore);
		System.out.println("Rating: "+userScore+"/"+totalScore);
		
		requestDispatcher = request.getServletContext().getRequestDispatcher("/quiz_result.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
 