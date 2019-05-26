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
	
	<form action="FinishQuiz" method="POST">
	
		<input type="hidden" name="quizTopic" value="${sessionScope.topic}">
	
		<c:forEach var="question" items="${questionList}">
		
			<c:set var="count" value="${count + 1}" scope="page" />
			
			<h3>Question #${count})</h3>
			<p>${question.question}</p>
			
			<input type="radio" name="option${count}" value="A">A) ${question.optionA}
			<input type="radio" name="option${count}" value="B">B) ${question.optionB}
			<input type="radio" name="option${count}" value="C">C) ${question.optionC}
			<input type="radio" name="option${count}" value="D">D) ${question.optionD}
			<input type="radio" name="option${count}" value="E">E) ${question.optionE}
			
			<input type="hidden" name="answer${count}" value="${question.answer}" >
			
			<br>
			
			Key Answer: <c:out value="${question.answer}" />
			<br>
			
		</c:forEach>
		
		<input type="hidden" name="questionCount" value="${count}" >
		
		<input type="submit" value="SUBMIT ANSWERS">
		
	</form>
	
	<hr>
	
	Total Question Count: <c:out value="${count}" />
	<a href="index.jsp">Cancel Quiz</a>

</body>

</html>