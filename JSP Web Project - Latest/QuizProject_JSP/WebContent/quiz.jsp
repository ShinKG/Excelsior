<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>EXCELSIOR! JSP Quiz WebApp</title>
</head>

<body>

	<center>
	
	<h1><c:out value="${sessionScope.topic}"/> Quiz</h1>
	
	<hr>
	
	<c:set var="count" value="0" scope="page" />
	
	<form action="SubmitAnswers" method="POST">
	
		<input type="hidden" name="quizTopic" value="${sessionScope.topic}">
		
		<!-- 
			Start of forEach loop.
			
			Display all questions from questionList object.
		-->
		
		<c:forEach var="question" items="${questionList}">
		
			<c:set var="count" value="${count + 1}" scope="page" />
			
			<div id="questionContainer">
				<div id="question_${count}">
					
					<h2>Question #${count}</h2>
					<p>${question.question}</p>
					
					<!-- 
						Question answer choices.
					-->
					
					<input type="radio" name="option${count}" value="A_${question.optionA}" required>A. ${question.optionA}<br>
					<input type="radio" name="option${count}" value="B_${question.optionB}">B. ${question.optionB}<br>
					<input type="radio" name="option${count}" value="C_${question.optionC}">C. ${question.optionC}<br>
					<input type="radio" name="option${count}" value="D_${question.optionD}">D. ${question.optionD}<br>
					<input type="radio" name="option${count}" value="E_${question.optionE}">E. ${question.optionE}<br>
					
					<input type="hidden" name="questionID${count}" value="${question.questionID}">
					<input type="hidden" name="question${count}" value="${question.question}">
					<input type="hidden" name="answer${count}" value="${question.answer}" >
					
					<br>
					
				</div>
			</div>
			
		</c:forEach>
		
		<!-- 
			End of forEach loop.
		-->
		
		<hr>
		
		<br>
		<input type="hidden" name="questionCtr" value="${count}" >
		<input type="submit" value="SUBMIT ANSWERS">
		
	</form>
	
	<br>
	<input type="button" onclick="location.href='index.jsp';" value="CANCEL QUIZ ATTEMPT" />
	<br>
	
	<hr>
	
	</center>

</body>

</html>