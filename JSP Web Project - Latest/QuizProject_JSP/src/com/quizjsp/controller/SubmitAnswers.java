/*  
 * @author Jaewin-Chino Ramos
 */

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
		
		// Instantiation of variables
		int questionCtr = 0;
		int questionID = 0;
		String Question = "";
		String UserAnswerRaw = "";
		String UserAnswerSplit[] = null;
		String UserAnswer = "";
		String UserAnswerDesc = "";
		String KeyAnswer = "";
		
		questionCtr = Integer.parseInt(request.getParameter("questionCtr"));
		quizSession.setAttribute("question_count", questionCtr);
		
		// Get all user answer data and store them into
		// an ArrayList
		//
		// Start of for loop
		for (int ctr = 1; ctr <= questionCtr; ctr++) {
			
			if (request.getParameter("option"+ctr) != null) {
				
				// Retrieve data from web page
				questionID = Integer.parseInt(request.getParameter("questionID"+ctr));
				Question = request.getParameter("question"+ctr);
				UserAnswerRaw = request.getParameter("option"+ctr);
				UserAnswerSplit = UserAnswerRaw.split("_");
				UserAnswer = UserAnswerSplit[0];
				UserAnswerDesc = UserAnswerSplit[1];
				KeyAnswer = request.getParameter("answer"+ctr);
				
				// Pass data to a UserAnswerInfo object
				UserAnswerInfo userAnswerInfo = new UserAnswerInfo();
				userAnswerInfo.setQuestionID(questionID);
				userAnswerInfo.setQuestion(Question);
				userAnswerInfo.setUserAnswer(UserAnswer);
				userAnswerInfo.setUserAnswerDesc(UserAnswerDesc);
				userAnswerInfo.setKeyAnswer(KeyAnswer);
				userAnswerList.add(userAnswerInfo);
				
				quizSession.setAttribute("question_id_"+ctr, questionID);
				quizSession.setAttribute("question_"+ctr, Question);
				quizSession.setAttribute("user_answer_"+ctr, UserAnswerSplit[0]);
				quizSession.setAttribute("user_answer_desc_"+ctr, UserAnswerSplit[1]);
				quizSession.setAttribute("key_answer_"+ctr, KeyAnswer);
				
			}
			
		}
		// End of for loop
		
		// Add userAnswerList session attribute to allow
		// retrieval and display of data on the
		// quiz review page
		quizSession.setAttribute("userAnswerList", userAnswerList);
		
		requestDispatcher = request.getServletContext().getRequestDispatcher("/quiz_review.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
