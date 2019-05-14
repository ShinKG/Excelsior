<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>login_student.jsp</title>
</head>

<body>

	<h1>LOGIN_STUDENT.JSP PAGE</h1>
	<hr>
	
	<form action="LoginStudent" method="POST">
		Username: <input type="text" name="username" required><br>
		Password: <input type="password" name="password" required><br>
		<input type="submit" value="Login">
	</form>
	
	<br>
	<a href="index.jsp">Go Back</a>

</body>

</html>