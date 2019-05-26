package com.quizjsp.model;

public class QuestionInfo {
	
	private String Topic;
	private String Question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	private String OptionE;
	private String Answer;
	private int questionID;
	
	public QuestionInfo() {
	}
	
	public QuestionInfo(
					int questionID,
					String Topic,
					String Question,
					String OptionA,
					String OptionB,
					String OptionC,
					String OptionD,
					String OptionE,
					String Answer) {
		
		this.questionID = questionID;
		this.Topic = Topic;
		this.Question = Question;
		this.OptionA = OptionA;
		this.OptionB = OptionB;
		this.OptionC = OptionC;
		this.OptionD = OptionD;
		this.OptionE = OptionE;
		this.Answer = Answer;
		
	}
	
	public int getQuestionID() {
		return questionID;
	}
	
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
	public String getTopic() {
		return Topic;
	}
	
	public void setTopic(String Topic) {
		this.Topic = Topic;
	}
	
	public String getQuestion() {
		return Question;
	}
	
	public void setQuestion(String Question) {
		this. Question = Question;
	}
	
	public String getOptionA() {
		return OptionA;
	}
	
	public void setOptionA(String OptionA) {
		this.OptionA = OptionA;
	}
	
	public String getOptionB() {
		return OptionB;
	}
	
	public void setOptionB(String OptionB) {
		this.OptionB = OptionB;
	}
	
	public String getOptionC() {
		return OptionC;
	}
	
	public void setOptionC(String OptionC) {
		this.OptionC = OptionC;
	}
	
	public String getOptionD() {
		return OptionD;
	}
	
	public void setOptionD(String OptionD) {
		this.OptionD = OptionD;
	}
	
	public String getOptionE() {
		return OptionE;
	}
	
	public void setOptionE(String OptionE) {
		this.OptionE = OptionE;
	}
	
	public String getAnswer() {
		return Answer;
	}
	
	public void setAnswer(String Answer) {
		this.Answer = Answer;
	}

}
