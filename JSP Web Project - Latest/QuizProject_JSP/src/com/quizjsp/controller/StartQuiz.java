package com.quizjsp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quizjsp.model.QuestionInfo;
import com.quizjsp.model.QuizDAO;

@WebServlet("/StartQuiz")
public class StartQuiz extends HttpServlet {

	QuizDAO quizDAO = new QuizDAO();
	
	String QuizTopic = "";
	int numberOfQuestions = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QuestionInfo> questionList;
		
		QuizTopic = request.getParameter("quizTopic");
		numberOfQuestions = Integer.parseInt(request.getParameter("numOfQuestions"));
		
		try {
			
			questionList = quizDAO.getQuestionList(quizDAO.createDBConnection(), QuizTopic, numberOfQuestions);
			request.setAttribute("questionList", questionList);
			
			RequestDispatcher requestDispatcher;
			requestDispatcher = request.getServletContext().getRequestDispatcher("/quiz.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		quizDAO.closeDBConnection();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			quizDAO.getQuestionList(quizDAO.createDBConnection(), QuizTopic, numberOfQuestions);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
