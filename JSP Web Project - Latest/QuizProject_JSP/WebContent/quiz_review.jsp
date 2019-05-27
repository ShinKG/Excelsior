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
	
	<h1><c:out value="${sessionScope.topic}"/> - Quiz Answer Review</h1>
	
	<h2>Your Selected Answers: </h2>
	
	<hr>
	
	<c:set var="ctr" value="0" scope="page" />
	
	<form action="FinishQuiz" method="POST">
		
		<!-- 
			Start of forEach loop.
			
			Display all questions and the user's answer for each questions.
		-->
		
		<c:forEach var="answer" items="${userAnswerList}">
			
			<c:set var="ctr" value="${ctr + 1}" scope="page" />
			
			<h3>Question #${ctr}</h3>
			
			<h4>${answer.question}</h4>
			
			<p>Your Answer: <b>${answer.userAnswer}. ${answer.userAnswerDesc}</b></p>
			
			<hr>
			
		</c:forEach>
		
		<!-- 
			End of forEach loop.
		-->
		
		<input type="hidden" name="questionCtr" value="${sessionScope.question_count}" >
		<input type="submit" value="FINISH QUIZ">
		
	</form>
	
	<br>
	<input type="button" value="CHANGE ANSWERS" onclick="javascript:history.go(-1)">
	<br>
	
	<br>
	<input type="button" onclick="location.href='index.jsp';" value="CANCEL QUIZ ATTEMPT" />
	<br>
	
	<hr>
	
	</center>

</body>

</html>