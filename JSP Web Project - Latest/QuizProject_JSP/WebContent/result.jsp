<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>RESULT.JSP</title>
</head>

<body>
	
	<h1>RESULT.JSP PAGE</h1>
	
	<h2><c:out value="${sessionScope.topic}"/> Quiz Results</h2>
	
	<h3>Score:</h3>
	<c:out value="${sessionScope.user_score}"/> / <c:out value="${sessionScope.total_score}"/>
	<br>
	
	<h3>Evaluation:</h3>
	<c:out value="${sessionScope.evaluation}"/>
	<br>
	
	<a href="index.jsp">Back to Homepage</a>
	
</body>

</html>