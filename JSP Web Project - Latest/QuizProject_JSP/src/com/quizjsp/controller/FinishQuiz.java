/*  
 * @author Jaewin-Chino Ramos, Hershey Nicole Bagcal, Kyeongho Shin
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

import com.quizjsp.model.QuizDAO;
import com.quizjsp.model.UserAnswerInfo;

@WebServlet("/FinishQuiz")
public class FinishQuiz extends HttpServlet {
	
	QuizDAO quizDAO = new QuizDAO();
	RequestDispatcher requestDispatcher;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession quizSession = request.getSession();
		List<UserAnswerInfo> userAnswerList = new ArrayList<UserAnswerInfo>();
		
		int totalScore = 0;
		int userScore = 0;
		int questionID = 0;
		String QuizTopic = "";
		String Question = "";
		String UserAnswer = "";
		String UserAnswerDesc = "";
		String KeyAnswer = "";
		String KeyAnswerDesc = "";
		
		QuizTopic = (String) quizSession.getAttribute("topic");
		totalScore = Integer.parseInt(request.getParameter("questionCtr"));
		
		for (int ctr = 1; ctr <= totalScore; ctr++) {
			
			questionID = (Integer) quizSession.getAttribute("question_id_"+ctr);
			Question = (String) quizSession.getAttribute("question_"+ctr);
			UserAnswer = (String) quizSession.getAttribute("user_answer_"+ctr);
			UserAnswerDesc = (String) quizSession.getAttribute("user_answer_desc_"+ctr);
			KeyAnswer = (String) quizSession.getAttribute("key_answer_"+ctr);
			KeyAnswerDesc = quizDAO.getKeyAnswer(quizDAO.createDBConnection(), questionID, KeyAnswer);
			quizSession.setAttribute("key_answer_desc_"+ctr, KeyAnswerDesc);
			
			UserAnswerInfo userAnswerInfo = new UserAnswerInfo();
			userAnswerInfo.setQuestionID(questionID);
			userAnswerInfo.setQuestion(Question);
			userAnswerInfo.setUserAnswer(UserAnswer);
			userAnswerInfo.setUserAnswerDesc(UserAnswerDesc);
			userAnswerInfo.setKeyAnswer(KeyAnswer);
			userAnswerInfo.setKeyAnswerDesc(KeyAnswerDesc);
			userAnswerList.add(userAnswerInfo);
			
			quizSession.setAttribute("evalUserAnswerList", userAnswerList);
			
			if (UserAnswer.equals(KeyAnswer)) {
				userScore++;
			}
			
		}
		
		// User score evaluation
		
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
		
		// Pass the evaluation data to session variable
		
		quizSession.setAttribute("user_score", userScore);
		quizSession.setAttribute("total_score", totalScore);
		quizSession.setAttribute("evaluation", Evaluation);
		
		requestDispatcher = request.getServletContext().getRequestDispatcher("/quiz_result.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
 