<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>QUIZ.JSP</title>
</head>

<body>

	<h1>QUIZ.JSP PAGE</h1>
	
	<h2><c:out value="${sessionScope.topic}"/> Quiz</h2>
	
	<c:set var="count" value="0" scope="page" />
	
	<form action="SubmitAnswers" method="POST">
	
		<input type="hidden" name="quizTopic" value="${sessionScope.topic}">
	
		<c:forEach var="question" items="${questionList}">
		
			<c:set var="count" value="${count + 1}" scope="page" />
			
			<div>
				
				<h3>Question #${count}</h3>
				<p>${question.question}</p>
				
				<input type="radio" name="option${count}" value="A_${question.optionA}">A) ${question.optionA}
				<input type="radio" name="option${count}" value="B_${question.optionB}">B) ${question.optionB}
				<input type="radio" name="option${count}" value="C_${question.optionC}">C) ${question.optionC}
				<input type="radio" name="option${count}" value="D_${question.optionD}">D) ${question.optionD}
				<input type="radio" name="option${count}" value="E_${question.optionE}">E) ${question.optionE}
				
				<input type="hidden" name="question${count}" value="${question.question}">
				<input type="hidden" name="answer${count}" value="${question.answer}" >
				
				<br>
				
				Key Answer: <c:out value="${question.answer}" />
				<br>
				
			</div>
			
		</c:forEach>
		
		<input type="hidden" name="questionCtr" value="${count}" >
		
		<input type="submit" value="SUBMIT ANSWERS">
		
	</form>
	
	<hr>
	
	Total Question Count: <c:out value="${count}" />
	<a href="index.jsp">Cancel Quiz</a>

</body>

</html>