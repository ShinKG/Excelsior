package com.quizjsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quizjsp.model.UserAnswerInfo;

@WebServlet("/SubmitAnswers")
public class SubmitAnswers extends HttpServlet {
	
	RequestDispatcher requestDispatcher;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession quizSession = request.getSession();
		List<UserAnswerInfo> userAnswerList = new ArrayList<UserAnswerInfo>();
		
		//List<QuestionInfo> questionList = new ArrayList<QuestionInfo>();
		
		String QuizTopic = "";
		String Question = "";
		String UserAnswerRaw = "";
		String UserAnswerSplit[] = null;
		String UserAnswer = "";
		String UserAnswerDesc = "";
		String KeyAnswer = "";
		int questionCtr = 0;
		
		QuizTopic = (String) quizSession.getAttribute("topic");
		
		questionCtr = Integer.parseInt(request.getParameter("questionCtr"));
		quizSession.setAttribute("question_count", questionCtr);
		
		for (int ctr = 1; ctr <= questionCtr; ctr++) {
			
			if (request.getParameter("option"+ctr) != null) {
				
				Question = request.getParameter("question"+ctr);
				UserAnswerRaw = request.getParameter("option"+ctr);
				UserAnswerSplit = UserAnswerRaw.split("_");
				UserAnswer = UserAnswerSplit[0];
				UserAnswerDesc = UserAnswerSplit[1];
				KeyAnswer = request.getParameter("answer"+ctr);
				
				UserAnswerInfo userAnswerInfo = new UserAnswerInfo();
				userAnswerInfo.setQuestion(Question);
				userAnswerInfo.setUserAnswer(UserAnswer);
				userAnswerInfo.setUserAnswerDesc(UserAnswerDesc);
				userAnswerInfo.setKeyAnswer(KeyAnswer);
				userAnswerList.add(userAnswerInfo);
				
				quizSession.setAttribute("question_"+ctr, Question);
				quizSession.setAttribute("user_answer_"+ctr, UserAnswerSplit[0]);
				quizSession.setAttribute("user_answer_desc_"+ctr, UserAnswerSplit[1]);
				quizSession.setAttribute("key_answer_"+ctr, KeyAnswer);
				
			}
			
		}
		
		quizSession.setAttribute("userAnswerList", userAnswerList);
		
		System.out.println("Submitted Quiz Data:");
		System.out.println("Questions Answered: " + questionCtr);
		
		for (int ctr = 1; ctr <= questionCtr; ctr++) {
			
			System.out.println("User Answer for question #" + ctr + " from Session: " + quizSession.getAttribute("user_answer_"+ctr));
			System.out.println("User Answer Description: " + quizSession.getAttribute("user_answer_desc_"+ctr));
			System.out.println("Key Answer for question #" + ctr + " from Session: " + quizSession.getAttribute("key_answer_"+ctr));
			System.out.println();
			
		}
		
		System.out.println();
		
		requestDispatcher = request.getServletContext().getRequestDispatcher("/quiz_review.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
