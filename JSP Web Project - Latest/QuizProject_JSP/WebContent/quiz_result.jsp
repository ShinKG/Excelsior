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
	
	<h1><c:out value="${sessionScope.topic}"/> Quiz Results</h1>
	
	<hr>
	
	<p>SCORE:</p>
	<h3><c:out value="${sessionScope.user_score}"/> / <c:out value="${sessionScope.total_score}"/></h3>
	
	<p>EVALUATION:</p>
	<h3><c:out value="${sessionScope.evaluation}"/></h3>
	<br>
	
	<p>DETAILED EVALUATION:</p>
	
	<table border="1" cellpadding="8px">
		
		<tr>
			<th>Question:</th>
			<th>Your Answer:</th>
			<th>Correct Answer:</th>
		</tr>
		
		<c:forEach var="evaluation" items="${evalUserAnswerList}">
		<tr>
			<td>${evaluation.question}</td>
			<td>${evaluation.userAnswer}. ${evaluation.userAnswerDesc}</td>
			<td>${evaluation.keyAnswer}. ${evaluation.keyAnswerDesc}</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<br>
	
	<input type="button" onclick="location.href='index.jsp';" value="BACK TO HOMEPAGE" />
	
	<br>
	
	<hr>
	
	</center>
	
</body>

</html>