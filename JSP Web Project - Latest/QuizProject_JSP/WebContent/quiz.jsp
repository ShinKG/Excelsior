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
	
	<h2>${question.topic}</h2>
	
	<form action="#">
		<c:set var="count" value="0" scope="page" />
		<c:forEach var="question" items="${questionList}">
			<c:set var="count" value="${count + 1}" scope="page" />
			
			<h3>Question #${count})</h3>
			<p>${question.question}</p>
			
				<input type="radio" name="option${count}" value="A">${question.optionA}
				<input type="radio" name="option${count}" value="B">${question.optionB}
				<input type="radio" name="option${count}" value="C">${question.optionC}
				<input type="radio" name="option${count}" value="D">${question.optionD}
				<input type="radio" name="option${count}" value="E">${question.optionE}
				<input type="hidden" name="answer" value="${question.answer}">
			
		</c:forEach>
		
		<br>
		
		<input type="submit" value="SUBMIT ANSWERS">
	</form>
	
	<hr>
	
	<a href="index.jsp">Cancel Quiz</a>

</body>

</html>