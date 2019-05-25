<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>DESC_HTML.JSP</title>
</head>

<body>

	<h1>DESC_HTML.JSP</h1>
	
	<p>HTML QUIZ Description paragraph</p>
	
	<p>Input the number of questions that you would want to answer for the quiz.</p>
	<p>There are a total of 15 questions available.</p>
	
	<form action="StartQuiz" method="POST">
		<input type="hidden" name="quizTopic" value="html">
		<input type="number" name="numOfQuestions" min="1" max="15" required>
		<br>
		<input type="submit" value="Start the Quiz">
	</form>
	<br>
	<a href="index.jsp">Go Back</a>

</body>

</html>