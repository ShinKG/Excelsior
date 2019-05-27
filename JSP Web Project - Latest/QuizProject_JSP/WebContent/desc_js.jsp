<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>EXCELSIOR! JSP Quiz WebApp</title>
</head>

<body>

	<center>
	
	<h1>JavaScript Quiz</h1>
	
	<p>Input the number of questions that you would want to answer for the quiz.</p>
	<p>There are a total of 15 questions available.</p>
	
	<form action="StartQuiz" method="POST">
		<input type="hidden" name="quizTopic" value="js">
		<input type="number" name="numOfQuestions" min="1" max="15" required>
		<br><br>
		<input type="submit" value="START THE QUIZ">
	</form>
	<br>
	<input type="button" onclick="location.href='index.jsp';" value="GO BACK" />
	
	</center>

</body>

</html>