<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>QUIZ_REVIEW.JSP</title>
</head>

<body>

	<h1>QUIZ_RESULT.JSP PAGE</h1>
	
	<h2>Your Selected Answers: </h2>
	
	<c:set var="ctr" value="0" scope="page" />
	
	<c:forEach var="answer" items="${userAnswerList}">
		
		<c:set var="ctr" value="${ctr + 1}" scope="page" />
		
		<h3>Question ${ctr}</h3>
		
		<h4>${answer.question}</h4>
		
		<p>Your Answer: ${answer.userAnswer} ${answer.userAnswerDesc}</p>
		
	</c:forEach>
	
	<input type="button" value="Change Answers" onclick="javascript:history.go(-1)">
	<br>
	<a href="index.jsp">Cancel Quiz</a>

</body>

</html>