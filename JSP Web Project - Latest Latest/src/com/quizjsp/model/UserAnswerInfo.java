package com.quizjsp.model;

public class UserAnswerInfo {
		
	private String Question;
	private String UserAnswer;
	private String UserAnswerDesc;
	private String KeyAnswer;
	
	public UserAnswerInfo() {
	}
	
	public UserAnswerInfo(
					String Question,
					String UserAnswer,
					String UserAnswerDesc,
					String KeyAnswer) {
		
		this.Question = Question;
		this.UserAnswer = UserAnswer;
		this.UserAnswerDesc = UserAnswerDesc;
		this.KeyAnswer = KeyAnswer;
		
	}
	
	public String getQuestion() {
		return Question;
	}
	
	public void setQuestion(String Question) {
		this.Question = Question;
	}
	
	public String getUserAnswer() {
		return UserAnswer;
	}
	
	public void setUserAnswer(String UserAnswer) {
		this.UserAnswer = UserAnswer;
	}
	
	public String getUserAnswerDesc() {
		return UserAnswerDesc;
	}
	
	public void setUserAnswerDesc(String UserAnswerDesc) {
		this.UserAnswerDesc = UserAnswerDesc;
	}
	
	public String getKeyAnswer() {
		return KeyAnswer;
	}
	
	public void setKeyAnswer(String KeyAnswer) {
		this.KeyAnswer = KeyAnswer;
	}

}
